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

</body>
</html>
</#macro>