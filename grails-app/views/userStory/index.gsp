
<%@ page import="wwyg.UserStory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-userStory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-userStory" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>

                        <g:sortableColumn property="id" title="Id"/>
						<g:sortableColumn property="title" title="${message(code: 'userStory.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="author" title="${message(code: 'userStory.author.label', default: 'Author')}" />
					
						<g:sortableColumn property="contactEmail" title="${message(code: 'userStory.contactEmail.label', default: 'Contact Email')}" />
					
						%{--<g:sortableColumn property="story" title="${message(code: 'userStory.story.label', default: 'Story')}" />--}%
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'userStory.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'userStory.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userStoryInstanceList}" status="i" var="userStoryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td>${userStoryInstance.id}</td>
						<td><g:link action="edit" id="${userStoryInstance.id}">${fieldValue(bean: userStoryInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: userStoryInstance, field: "author")}</td>
					
						<td>${fieldValue(bean: userStoryInstance, field: "contactEmail")}</td>
					
						%{--<td>${raw(userStoryInstance.story)}</td>--}%
					
						<td><g:formatDate date="${userStoryInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${userStoryInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userStoryInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
