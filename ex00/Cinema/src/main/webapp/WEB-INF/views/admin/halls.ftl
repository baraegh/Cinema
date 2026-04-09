<#import "../layout.ftl" as layout>

<@layout.mainLayout title="Movie Halls">
    <h1>Movie Halls</h1>

    <table border="1">
        <tr>
            <th>Number</th>
            <th>Seats</th>
        </tr>
        <#list halls as hall>
            <tr>
                <td>${hall.serialNumber!0}</td>
                <td>${hall.seatsCount!0}</td>
            </tr>
        <#else>
            <tr>
                <td colspan="2">No halls yet</td>
            </tr>
        </#list>
    </table>

    <h2>Create New Hall</h2>
    <form method="post" action="/cinema/admin/panel/halls/save">
        <div>
            <label>Hall number</label>
            <input type="number" name="serialNumber" placeholder="Hall number" required/>
        </div>
        <div>
            <label>Seats</label>
            <input type="number" name="seatsCount" placeholder="Seats" required/>
        </div>
        <button type="submit">Create</button>
    </form>

</@layout.mainLayout>