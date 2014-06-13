<%@ page import="wwyg.UserStory" %>



<div class="fieldcontain ${hasErrors(bean: userStoryInstance, field: 'category', 'error')} required">
    <label for="contactEmail">
        <g:message code="userStory.contactEmail.label" default="Category" />
        <span class="required-indicator">*</span>
    </label>
    <g:select name="category" from="${category}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userStoryInstance, field: 'title', 'error')} required">
    <label for="title">
        <g:message code="userStory.title.label" default="Title" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="title" maxlength="255" required="" value="${userStoryInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userStoryInstance, field: 'author', 'error')} required">
    <label for="author">
        <g:message code="userStory.author.label" default="Author" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="author" maxlength="255" required="" value="${userStoryInstance?.author}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userStoryInstance, field: 'contactEmail', 'error')} required">
    <label for="contactEmail">
        <g:message code="userStory.contactEmail.label" default="Contact Email" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="contactEmail" maxlength="255" required="" value="${userStoryInstance?.contactEmail}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userStoryInstance, field: 'story', 'error')} required">
    <label for="story">
        <g:message code="userStory.story.label" default="Story" />
        <span class="required-indicator">*</span>
    </label>
    <ckeditor:editor name="story" height="400px" width="80%">
        ${userStoryInstance.story}
    </ckeditor:editor>

</div>