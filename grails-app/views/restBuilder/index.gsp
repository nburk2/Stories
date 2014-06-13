<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/6/14
  Time: 8:45 AM
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

    <g:form name="myForm" action="">
        <table>
            <tr><td>
                <input typ="text" name="GET"> </input>
                <g:actionSubmit value="Get request" action="restRequest"/>
                What attribute do you want to get.
            </td></tr>
            <tr><td>
                <input typ="text" name="POST"> </input>
                <g:actionSubmit value="Post request" action="restRequest"/>
                What attribute do you want to change
            </td></tr>
        </table>

    </g:form>

</body>
</html>