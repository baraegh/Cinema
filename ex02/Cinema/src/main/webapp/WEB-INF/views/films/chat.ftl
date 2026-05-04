<#import "../layout.ftl" as layout>

<@layout.mainLayout title="Film Chat - Cinema">

<div class="chat-container">
    <!-- Main Chat Area -->
    <div class="chat-main">
        <div class="chat-header">
            <h2>💬 Film Discussion - ADD THE FILM'S TITLE</h2>
        </div>

        <div class="messages-area" id="messagesContainer">
            <div class="no-messages">Loading chat history...</div>
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
            <div class="sidebar-title">Your Profile</div>
            <div class="user-info">
                <div class="info-label">User ID</div>
                <div class="info-value" id="userIdDisplay">-</div>
            </div>
            <div class="user-info" style="margin-top: 0.75rem;">
                <div class="info-label">IP Address</div>
                <div class="info-value" id="ipAddressDisplay">-</div>
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

<script>
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

    var userId = getOrCreateUUID();
</script>

</@layout.mainLayout>
