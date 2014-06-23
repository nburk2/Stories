<%@ page import="wwyg.UserStory" %>
<!DOCTYPE html>
<html>
	<head>
        <ckeditor:resources/>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
        <div class="container" style="padding:70px">
            <h2>Edit your story</h2>
            <g:form role="form" url="[resource:userStoryInstance, action:'update']" method="PUT" >
                <g:hiddenField name="version" value="${userStoryInstance?.version}" />
                <fieldset class="form">
                    <g:render template="form"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="btn btn-md btn-success" type="submit" value="Update"/>
                </fieldset>
            </g:form>
        </div>
	</body>
</html>
