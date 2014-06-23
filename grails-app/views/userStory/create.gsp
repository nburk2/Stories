<!DOCTYPE html>
<html>
	<head>

		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
        <ckeditor:resources/>
	</head>
	<body>
    <div class="container" style="padding: 70px">
        <h2>Create your story</h2>
        <form role="form" method="post" action="save">
            <fieldset class="form">
                <g:render template="form"/>
            </fieldset>
            <input class="btn btn-md btn-success" type="submit" value="Create" id="btnnext"/>
        </form>
    </div>
	</body>
</html>
