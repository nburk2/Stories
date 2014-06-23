<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/5/14
  Time: 8:28 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <g:javascript>
        function checkConditions() {
            if (!document.getElementById("chkaccept").checked) {

                document.getElementById("flag").innerHTML = "Please accept the terms & conditions.";
                return false;
            }

            else {
                return true;
            }
        }

    </g:javascript>

    <title></title>
</head>

<body>
    <div class="container" style="padding-top: 70px;">
        <div class="col-md-12">
        <div class="jumbotron hero-spacer">
            <h1>Ready to share your story?</h1>
            <p>Collaborate with hundreds of others to share inspiring stories that will encourage, strengthen and motivate
                people in your past or current situation.
            </p>
        </div>
        </div>

        <div class="clearfix"></div>
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                        Here's how it works
                    </div>
                </div>
                <div class="panel-body">
                    <ol><li>Read and accept the Terms and Conditions below</li>
                        <li>Create your story using our Story Wizard, with optional images or video</li>
                    </ol>
                </div>
            </div>
        </div>

            <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">Get the word out</div>
                </div>
                <div class="panel-body">
                    <p>After your create your story:</p>
                    <ol>
                        <li>Share your story on our site, and your social media sites</li>
                        <li>Download a free personalized infographic of your story to share</li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
        <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title pull-left">Terms and Conditions</h3>
                <h1 class="panel-title pull-right"><a href="http://www.cdc.gov/other/privacy.html">Views Privacy Policy</a></h1>
                <div class="clearfix"></div>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="category" method="post" onSubmit="return checkConditions()">
                    <textarea class="form-control" rows="3">
                        ${TermsAndConditions}
                    </textarea>

                    <div class="row col-lg-4 pull-right">
                    <td colspan="2" style="text-align:center;"><p style="display:inline;"><input type="checkbox" name="checkaccept" id="chkaccept" value="I Accept" />
                        <label for="chkaccept">I Accept!</label> &nbsp;<input type="submit" class="btn btn-md btn-success" value="I'm Ready!" id="btnsubmit"/></p> </td>
                    <p id="flag" style="color:red"></p>
                    </div>
                </form>
            </div>
        </div>
        </div>
    </div>
</body>
</html>