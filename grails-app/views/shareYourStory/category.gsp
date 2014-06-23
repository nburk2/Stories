<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/5/14
  Time: 9:16 AM
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
            <style>
                table[id="content"]{
                    float: right;
                }
                table[id="category"]{

                }
            </style>

        <div class="container" style="padding-top: 70px;">
            <div class="jumbotron hero-spacer">

                <h1>Select a category below</h1>
                <p>
                    This helps us share your story with people looking for what you have to say!
                </p>
            </div>

            <hr/>
            <div class="clearfix"></div>
            <form role="form" action="/UserStory/create" method="get">
                        <div class="row text-center">
                        <g:each in="${categoryList}" status="i" var="category">

                            <div class="col-lg-3 col-md-6 hero" style="padding: 10px">
                                <div class="thumbnail">
                                    <div class="caption">
                                        <g:link controller="shareYourStory" action="stories" id="${category}" elementId="${category}story">${category}</g:link>
                                    </div>
                                </div>
                            </div>

                            <r:script>
                                $('#${category}story').click(function() {
                                    $('#divcatdetails').css("display", "display");
                                    $('#divcatdetails').load(this.href); return false;
                                });
                            </r:script>
                        </g:each>
                        </div>
                        <tr>
                            <td>
                                <g:link controller="UserStory" action="create"><input class="btn btn-md btn-success pull-right" type="button" value="Create your own story" id="btnnext"/></g:link>
                            </td>
                        </tr>

                        <div class="panel panel-default" style="display:none" id="divcatdetails"/>

            </form>
        </div>
    </body>
</html>