<div class="panel-heading">
    <div class="panel-title">
               Past stories on ${category}:
    </div>
</div>
<div class="panel-body">
<g:each in="${content}" status="j" var="links">
    <tr>
        <td>
            <p>
               <a href="${links}">${links}</a>
            </p>
        </td>
    </tr>
</g:each>
    <g:if test="${content == []}"> There are no stories yet. You can be the first!</g:if>
</div>