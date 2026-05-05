<#import "../layout.ftl" as layout>

<@layout.mainLayout title="Film Chat - Cinema">

<div class="chat-container">
    <!-- Main Chat Area -->
    <div class="chat-main">
        <div class="chat-header">
            <h2>💬 Film Discussion - ${(film.title)!"Unknown film"}</h2>
        </div>

        <div class="messages-area" id="messagesContainer">
            <#list initialMessages?reverse as msg>
                <div class="message">
                    <div class="message-header">
                    <span class="message-user">${msg.userId!"Anonymous"}</span>
                    <span class="message-time">${msg.formattedDateTime!" - "}</span>
                    </div>
                    <div class="message-text">${msg.msg!""}</div>
                </div>
            <#else>
                <div class="no-messages">No messages yet</div>
            </#list>
        </div>

        <div class="input-area">
            <div class="input-group">
                <input 
                    type="text" 
                    id="messageInput" 
                    placeholder="Type your message here..."
                    autocomplete="off"
                />
                <button id="sendBtn">Send</button>
            </div>
        </div>
    </div>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Connection Status -->
        <div id="connectionStatus" class="connection-status disconnected">
            ⚫ Disconnected
        </div>

        <!-- User Info Panel -->
        <div class="sidebar-panel">
            <div class="sidebar-title">Your AuthenticationHistory</div>
            <div class="scrollable">
                <#list userAuthentication as us >
                    <div class="user-info ">
                        <div class="info-label">User ID</div>
                        <div class="info-value" id="userIdDisplay">${us.userId!"-"}</div>
                        <div class="info-label">IP Address</div>
                        <div class="info-value" id="ipAddressDisplay">${us.ipAdress!"-"}</div>
                        <div class="info-label">Date & Time</div>
                        <div class="info-value" id="dateTime">${us.formattedDateTime!"-"}</div>
                    </div>
                <#else>
                    <div class="user-info">
                        <div class="info-value">No record yet</div>
                    </div>
                </#list>
            </div>
        </div>

        <!-- Image Upload Panel -->
        <div class="sidebar-panel">
            <div class="sidebar-title">Upload Avatar</div>
            <form id="uploadForm" class="upload-form">
                <div class="file-input-wrapper">
                    <input type="file" id="imageInput" accept="image/*" />
                    <label for="imageInput" class="file-input-label">Choose Image</label>
                </div>
                <button type="submit" id="uploadBtn">Upload</button>
            </form>
        </div>

        <!-- Uploaded Images Panel -->
        <div class="sidebar-panel">
            <div class="sidebar-title">Avatars</div>
            <div class="images-list" id="imagesList">
                <div style="color: var(--text-muted); font-size: 0.85rem;">No images uploaded</div>
            </div>
        </div>
    </div>
</div>


<!-- SockJS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>

<!-- STOMP over SockJS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script>
    var filmId = ${filmId!0};

    function setCookie(name, value, days) {
        var expires = '';
        if (days) {
            var date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            expires = '; expires=' + date.toUTCString();
        }
        document.cookie = name + '=' + value + expires + '; path=/';
    }

    function getCookie(name) {
        var nameEQ = name + '=';
        var cookies = document.cookie.split(';');

        for (var i = 0; i < cookies.length; i++) {
            var cookie = cookies[i].trim();
            if (cookie.indexOf(nameEQ) === 0) {
                return cookie.substring(nameEQ.length);
            }
        }
        return null;
    }

    function getOrCreateUUID() {
        var existing = getCookie('userId');
        if (existing) {
            return existing;
        }
        var uuid = crypto.randomUUID();
        setCookie('userId', uuid, 30);
        return uuid;
    }

    document.addEventListener('DOMContentLoaded', function() {
        var stompClient = null;
        var isConnected = false;
        var userId = getOrCreateUUID();
        var messagesContainer = document.getElementById('messagesContainer');
        var messageInput = document.getElementById('messageInput');
        var sendBtn = document.getElementById('sendBtn');
        var renderedMessages = new Set();

        function buildMessageKey(message) {
            if (message.id) {
                return 'id:' + message.id;
            }
            return 'fallback:' + (message.userId || '') + '|' + (message.msg || '') + '|' + (message.dateTime || '');
        }

        function removeEmptyState() {
            var emptyState = messagesContainer.querySelector('.no-messages');
            if (emptyState) {
                emptyState.remove();
            }
        }

        function scrollMessagesToBottom() {
            messagesContainer.scrollTop = messagesContainer.scrollHeight;
        }

        function updateConnectionStatus(connected) {
            var statusEl = document.getElementById('connectionStatus');
            if (!statusEl) {
                return;
            }

            statusEl.classList.remove('connected', 'disconnected');
            statusEl.classList.add(connected ? 'connected' : 'disconnected');
            statusEl.textContent = connected ? '⚫ Connected' : '⚫ Disconnected';
        }

        function displayMessage(message) {

            removeEmptyState();

            var messageElement = document.createElement('div');
            messageElement.className = 'message';

            var formattedTime = message.formattedDateTime || '';
            if (!formattedTime && message.dateTime) {
                var timeValue = new Date(message.dateTime);
                formattedTime = timeValue && !Number.isNaN(timeValue.getTime())
                    ? timeValue.toLocaleString()
                    : '';
            }

            messageElement.innerHTML =
                '<div class="message-header">' +
                    '<span class="message-user">' + (message.userId || 'Anonymous') + '</span>' +
                    '<span class="message-time">' + formattedTime + '</span>' +
                '</div>' +
                '<div class="message-text">' + (message.msg || '') + '</div>';

            messagesContainer.appendChild(messageElement);
            scrollMessagesToBottom();
        }

        function connect() {
            var socket = new SockJS('/cinema/ws');
            stompClient = Stomp.over(socket);
            stompClient.debug = null;

            stompClient.connect({}, function() {
                isConnected = true;
                updateConnectionStatus(true);
                console.log('Connected');

                stompClient.subscribe('/topic/films/' + filmId + '/chat', function(message) {
                    displayMessage(JSON.parse(message.body));
                });
            }, function() {
                isConnected = false;
                updateConnectionStatus(false);
                console.log('Connection lost - reconnecting in 5s...');
                setTimeout(connect, 5000);
            });
        }

        function sendMessage(text) {
            stompClient.send(
                '/app/films/' + filmId + '/chat',
                {},
                JSON.stringify({
                    userId: userId,
                    msg: text,
                    filmId: filmId
                })
            );
        }

        sendBtn.addEventListener('click', function() {
            var text = messageInput.value.trim();
            if (text) {
                if (stompClient && isConnected) {
                    sendMessage(text);
                }
                messageInput.value = '';
            }
        });

        messageInput.addEventListener('keypress', function(event) {
            if (event.key === 'Enter') {
                sendBtn.click();
            }
        });

        window.addEventListener('beforeunload', function() {
            if (stompClient) {
                stompClient.disconnect();
            }
        });

        updateConnectionStatus(false);
        scrollMessagesToBottom();
        connect();
    });
</script>

</@layout.mainLayout>
