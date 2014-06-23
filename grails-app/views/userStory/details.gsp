
<%@ page import="wwyg.UserStory" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<div class="container" style="padding: 70px">
    <h2>Story</h2>
    <hr/>
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="panel-title"
                <h1>${userStoryInstance?.title}</h1>
            </div>
        </div>
        <div class="panel-body">
            <div class="col-md-12 col-md-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title">
                            Body
                        </div>
                    </div>
                    <div class="panel-body">
                        <g:if test="${userStoryInstance?.story}">
                            ${raw(userStoryInstance.story)}
                        </g:if>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="col-md-6 col-md-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title">
                             Author
                        </div>
                    </div>
                    <div class="panel-body">
                        <g:if test="${userStoryInstance?.author}">

                            <span class="property-value" aria-labelledby="title-label">${userStoryInstance.author}</span>

                        </g:if>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-md-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title">
                            Email
                        </div>
                    </div>
                    <div class="panel-body">
                    <g:if test="${userStoryInstance?.contactEmail}">
                            <span class="property-value" aria-labelledby="contactEmail-label"><g:fieldValue bean="${userStoryInstance}" field="contactEmail"/></span>
                    </g:if>
                    </div>
                </div>
            </div>

            <div class="clearfix"></div>
            <div class="col-md-6 col-md-lg-6">
               <div class="panel panel-default">
                   <div class="panel-heading">
                       <div class="panel-title">
                           Date Created
                       </div>
                   </div>
                   <div class="panel-body">
                       <g:if test="${userStoryInstance?.dateCreated}">
                           <li class="fieldcontain">
                               <span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${userStoryInstance?.dateCreated}" /></span>
                           </li>
                       </g:if>
                   </div>
               </div>
            </div>
                <div class="col-md-6 col-md-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">
                                Date Created
                            </div>
                        </div>
                        <div class="panel-body">
                            <g:if test="${userStoryInstance?.lastUpdated}">
                                <li class="fieldcontain">
                                    <span id="lastUpdated-label" class="property-label"><g:message code="userStory.lastUpdated.label" default="Last Updated" /></span>

                                    <span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${userStoryInstance?.lastUpdated}" /></span>

                                </li>
                            </g:if>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>
</body>
</html>
