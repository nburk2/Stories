<tr>
    <td>
        <p>
            Past stories on ${category}:
        </p>
    </td>
</tr>
<g:each in="${content}" status="j" var="links">
    <tr>
        <td>
            <p>
                <a href="${links}">${links}</a>
            </p>
        </td>
    </tr>
</g:each>