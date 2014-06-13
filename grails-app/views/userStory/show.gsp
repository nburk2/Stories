
<%@ page import="wwyg.UserStory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-userStory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-userStory" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list userStory">
			
				<g:if test="${userStoryInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="userStory.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${userStoryInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userStoryInstance?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="userStory.author.label" default="Author" /></span>
					
						<span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${userStoryInstance}" field="author"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userStoryInstance?.contactEmail}">
				<li class="fieldcontain">
					<span id="contactEmail-label" class="property-label"><g:message code="userStory.contactEmail.label" default="Contact Email" /></span>
					
						<span class="property-value" aria-labelledby="contactEmail-label"><g:fieldValue bean="${userStoryInstance}" field="contactEmail"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userStoryInstance?.story}">
				<li class="fieldcontain">
					<span id="story-label" class="property-label"><g:message code="userStory.story.label" default="Story" /></span>

                    <span class="property-value" aria-labelledby="story-label">${raw(userStoryInstance.story)}</span>

				</li>
				</g:if>
			
				<g:if test="${userStoryInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="userStory.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${userStoryInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userStoryInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="userStory.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${userStoryInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:userStoryInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${userStoryInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
