<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/19/14
  Time: 12:20 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<div class="container" style="padding-top:70px">
    <div class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title">
                    Your Stories
                </div>
            </div>
            <div class="panel-body">
                <g:if test="${userStoryInstanceCount > 0}">
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <div class="table-responsive">
                        <table class="table table-bordered table-condensed table-solid">
                            <thead>
                            <tr>

                                <g:sortableColumn property="id" title="Id"/>
                                <g:sortableColumn property="title" title="${message(code: 'userStory.title.label', default: 'Title')}" />

                                <g:sortableColumn property="title" title="Edit"/>

                                %{--<g:sortableColumn property="author" title="${message(code: 'userStory.author.label', default: 'Author')}" />--}%

                                %{--<g:sortableColumn property="contactEmail" title="${message(code: 'userStory.contactEmail.label', default: 'Contact Email')}" />--}%

                                %{--<g:sortableColumn class="hidden-xs hidden-sm" property="story" title="${message(code: 'userStory.story.label', default: 'Story')}" />--}%

                                <g:sortableColumn property="dateCreated" title="${message(code: 'userStory.dateCreated.label', default: 'Date Created')}" />

                                <g:sortableColumn property="lastUpdated" title="${message(code: 'userStory.lastUpdated.label', default: 'Last Updated')}" />

                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${userStoryInstanceList}" status="i" var="userStoryInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                                    <td>${userStoryInstance.id}</td>
                                    <td><g:link controller ="userStory" action="details" id="${userStoryInstance.id}">${fieldValue(bean: userStoryInstance, field: "title")}</g:link></td>

                                    <td>
                                        <g:link type="post" controller="userStory" action="edit" id="${userStoryInstance.user.id}" class="btn btn-md btn-success"><span>Edit</span></g:link>

                                        <g:form role="form" method="delete" controller="userStory" params="[userStoryId: userStoryInstance.id]" action="delete" id="${userStoryInstance.user.id}">
                                            <input type="submit" class="btn btn-md btn-success" value="Delete"/>
                                        </g:form>
                                    </td>

                                    %{--<td>${fieldValue(bean: userStoryInstance, field: "author")}</td>--}%

                                    %{--<td>${fieldValue(bean: userStoryInstance, field: "contactEmail")}</td>--}%

                                    %{--<td class="hidden-xs hidden-sm">${raw(userStoryInstance.story)}</td>--}%

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
                </g:if>
                <g:else>
                    You have not created any stories yet.
                    Make your first one here!
                    <a href="${createLink(controller:'shareYourStory', action:'index')}" class="btn btn-md btn-success" id="btnsubmit">
                        <span>Create Story</span>
                    </a>
                </g:else>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title">
                    Past comments
                </div>
            </div>
            <div class="panel-body">
                <ol>
                    <li>This will show past comments you made on other stories.</li>
                    <li>This will show past comments others made on your stories.</li>
                </ol>
            </div>
        </div>
    </div>
</div>
<div class="container" style="padding-top:70px">
    <div class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title">
                    Your Stories
                </div>
            </div>
            <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-condensed table-solid">
                            <thead>
                            <tr>

                                <g:sortableColumn property="id" title="Id"/>
                                <g:sortableColumn property="name" title="First name" />

                                <g:sortableColumn property="title" title="Edit"/>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${userInstanceList}" status="i" var="userInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                                    <td>${fieldValue(bean: userInstance, field: "id")}</td>
                                    <td>${fieldValue(bean: userInstance, field: "fName")}</td>
                                    <td>
                                        <g:form role="form" method="delete" controller="user" action="delete" id="${userInstance.id}">
                                            <input type="submit" class="btn btn-md btn-success" value="Delete"/>
                                        </g:form>
                                    </td>
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
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title">
                    Past comments
                </div>
            </div>
            <div class="panel-body">
                <ol>
                    <li>This will show past comments you made on other stories.</li>
                    <li>This will show past comments others made on your stories.</li>
                </ol>
            </div>
        </div>
    </div>
</div>
</body>
</html>