<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/5/14
  Time: 9:16 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <title></title>
</head>

<body>

    <style>
        table[id="content"]{
            float: right;
        }
        table[id="category"]{

        }
    </style>

<h3>Story Category</h3><br>
<p>choose a category that <strong>best fits</strong> what you want to talk about.<br />&nbsp; -This helps us share your story with people looking for what you have to say!</p>
<form action="/UserStory/create" method="get"><div class="validation-summary-valid" data-valmsg-summary="true"><ul><li style="display:none"></li>
</ul></div>    <div id="mydiv"></div>
    <div style="width: 800px; overflow: auto;">
        <table>
            <g:each in="${categoryList}" status="i" var="category">

                <tr><td><p><g:link controller="shareYourStory" action="stories" id="${category}" elementId="${category}story">${category}</g:link></p></td></tr>
                <r:script>
                    $('#${category}story').click(function() {
                        $('#divcatdetails').css("display", "display");
                        $('#categorydetail').load(this.href); return false;
                    });
                </r:script>
            </g:each>

                <td id="divcatdetails" style="display:none;padding-left:5em;">
                    <div style="height:450px; width:350px;background-color:#f5f5f5;">

                        <table id="content">

                                    <label id="categorydetail"></label>

                            <tr>
                                <td>
                                    <g:link controller="UserStory" action="create"><input type="button" value="Create your own story" id="btnnext"/></g:link>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
           </table>
    </div>
</form>
</body>
</html>