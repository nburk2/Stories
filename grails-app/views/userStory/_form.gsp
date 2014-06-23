<%@ page import="wwyg.UserStory" %>


<div class="fieldcontain ${hasErrors(bean: userStoryInstance, field: 'category', 'error')} required">
    <label for="contactEmail">
        <g:message code="userStory.contactEmail.label" default="Category" />
        <span class="required-indicator">*</span>
    </label>
    <g:select class="form-control" name="category" from="${category}"/>
</div>

<div class="form-group ${hasErrors(bean: userStoryInstance, field: 'title', 'error')} required">
    <label for="title">
        <g:message code="userStory.title.label" default="Title"/>
        <span class="required-indicator">*</span>
    </label>
    <input type="text" name="title" maxlength="255" required="" class="form-control" value="${userStoryInstance?.title}" placeholder="Enter title">
</div>

<div class="form-group ${hasErrors(bean: userStoryInstance, field: 'author', 'error')} required">
    <label for="author">
        <g:message code="userStory.author.label" default="Author"/>
        <span class="required-indicator">*</span>
    </label>
    <input type="text" maxlength="255" name="author" required="" class="form-control" value="${userStoryInstance?.author}" placeholder="Your name">
</div>

<div class="form-group ${hasErrors(bean: userStoryInstance, field: 'contactEmail', 'error')} required">
    <label for="email">
        <g:message code="userStory.contactEmail.label" default="Contact Email"/>
        <span class="required-indicator">*</span>
    </label>
    <input type="text" maxlength="255" name="contactEmail" required="" class="form-control" value="${userStoryInstance?.contactEmail}" placeholder="Email">
</div>


<div class="fieldcontain ${hasErrors(bean: userStoryInstance, field: 'story', 'error')} required">
    <label for="story">
        <g:message code="userStory.story.label" default="Story" />
        <span class="required-indicator">*</span>
    </label>
    <ckeditor:editor name="story" height="400px" width="100%">
        ${userStoryInstance.story}
    </ckeditor:editor>

</div>