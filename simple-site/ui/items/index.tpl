<%{:parent "../master.tpl"}%>

<h1>Items Index Page</h1>

<p>{{ message }}</p>


<table>
    {{#items}}<tr>
        <td><a href="/items/{{ id }}">{{ name }}</a></td>
    </tr>{{/items}}
</table>