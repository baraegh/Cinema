<#macro mainLayout title>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="/cinema/static/css/style.css"/>
</head>
<body>

    <!-- navbar — shared across all pages -->
    <nav>
        <a href="/cinema/sessions">Search</a>
        <a href="/cinema/admin/panel/halls">Halls</a>
        <a href="/cinema/admin/panel/films">Films</a>
        <a href="/cinema/admin/panel/sessions">Sessions</a>
    </nav>

    <!-- page specific content goes here -->
    <div class="content">
        <#nested>
    </div>

    <!-- footer — shared across all pages -->
    <footer>
        <p>Cinema App</p>
    </footer>

    <!-- Modal Script -->
    <script>
        function openModal(modalId) {
            const modal = document.getElementById(modalId);
            if (modal) {
                modal.classList.add('show');
            }
        }

        function closeModal(modalId) {
            const modal = document.getElementById(modalId);
            if (modal) {
                modal.classList.remove('show');
            }
        }

        // Close modal when clicking outside the modal content
        document.addEventListener('click', function(event) {
            if (event.target.classList.contains('modal')) {
                event.target.classList.remove('show');
            }
        });

        // Close modal when pressing Escape key
        document.addEventListener('keydown', function(event) {
            if (event.key === 'Escape') {
                const modals = document.querySelectorAll('.modal.show');
                modals.forEach(modal => {
                    modal.classList.remove('show');
                });
            }
        });
    </script>

</body>
</html>
</#macro>