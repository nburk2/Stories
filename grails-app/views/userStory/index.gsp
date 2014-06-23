
<%@ page import="wwyg.UserStory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
        <div class="container" style="padding: 70px">
            <div id="list-userStory" class="content scaffold-list" role="main">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title">
                            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
                        </div>
                    </div>
                    <div class="panel-body]">

                        %{--<g:if test="${flash.message}"> displays message that you just deleted some content--}%
                            %{--<div class="message" role="status">${flash.message}</div>--}%
                        %{--</g:if>--}%
                        <div class="table-responsive">
                        <table class="table table-bordered table-condensed table-solid">
                            <thead>
                            <tr>

                                <g:sortableColumn property="id" title="Id"/>
                                <g:sortableColumn property="title" title="${message(code: 'userStory.title.label', default: 'Title')}" />

                                <g:sortableColumn property="author" title="${message(code: 'userStory.author.label', default: 'Author')}" />

                                <g:sortableColumn property="contactEmail" title="${message(code: 'userStory.contactEmail.label', default: 'Contact Email')}" />

                                <g:sortableColumn class="hidden-xs hidden-sm" property="story" title="${message(code: 'userStory.story.label', default: 'Story')}" />

                                <g:sortableColumn property="dateCreated" title="${message(code: 'userStory.dateCreated.label', default: 'Date Created')}" />

                                <g:sortableColumn property="lastUpdated" title="${message(code: 'userStory.lastUpdated.label', default: 'Last Updated')}" />

                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${userStoryInstanceList}" status="i" var="userStoryInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                                    <td>${userStoryInstance.id}</td>
                                    <td><g:link action="details" id="${userStoryInstance.id}">${fieldValue(bean: userStoryInstance, field: "title")}</g:link></td>

                                    <td>${fieldValue(bean: userStoryInstance, field: "author")}</td>

                                    <td>${fieldValue(bean: userStoryInstance, field: "contactEmail")}</td>

                                    <td class="hidden-xs hidden-sm">${raw(userStoryInstance.story)}</td>

                                    <td><g:formatDate date="${userStoryInstance.dateCreated}" /></td>

                                    <td><g:formatDate date="${userStoryInstance.lastUpdated}" /></td>

                                </tr>
                            </g:each>
                            </tbody>
                        </table>
                        </div>
                        <div class="paginate page btn">
                            <g:paginate total="${userStoryInstanceCount ?: 0}" />
                        </div>
                    </div>
                </div>

            </div>
        </div>
	</body>
</html>
