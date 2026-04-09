<#import "../layout.ftl" as layout>

<@layout.mainLayout title="Movies">

    <h1>Movies</h1>

    <table border="1">
        <tr>
            <th>Title</th>
            <th>Year</th>
            <th>Age Restriction</th>
            <th>Description</th>
            <th>Poster</th>
        </tr>
        <#list films as film>
            <tr>
                <td>${film.title!''}</td>
                <td>${film.year!0}</td>
                <td>+${film.ageRestrictions!0}</td>
                <td>${film.description!''}</td>
                <td>
                    <#if film.posterUrl??>
                        <img src="${film.posterUrl}" width="60"/>
                    <#else>
                        No poster
                    </#if>
                </td>
            </tr>
        <#else>
            <tr>
                <td colspan="5">No films yet</td>
            </tr>
        </#list>
    </table>

    <h2>Add New Film</h2>
    <form method="post" action="/cinema/admin/panel/films/save" enctype="multipart/form-data">
        <div>
            <label>Title</label>
            <input type="text" name="title" placeholder="Title" required/>
        </div>
        <div>
            <label>Year</label>
            <input type="text" name="year" placeholder="Year" required/>
        </div>
        <div>
            <label>Age Restriction</label>
            <input type="number" name="ageRestrictions" placeholder="Age restriction" required/>
        </div>
        <div>
            <label>Description</label>
            <textarea name="description" placeholder="Description" required></textarea>
        </div>
        <div>
            <label>Poster</label>
            <input type="file" name="poster"/>
        </div>
        <button type="submit">Add Film</button>
    </form>

</@layout.mainLayout>