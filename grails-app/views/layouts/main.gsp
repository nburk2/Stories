<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 101 Template</title>

    <r:require module="jquery"/>
    %{--<r:require modules="bootstrap"/>--}%

    <r:require modules="application"/>
    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body>

    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class = "container">
            <div class = "navbar-header">
                <button class="navbar-toggle" data-target=".navbar-ex1-collapse" data-toggle="collapse" type="button">

                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>

                </button>
                <a class="navbar-brand" href="${createLink(controller:'userStory', action:'home')}">
                    Home
                </a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">

                <ul class="nav navbar-nav">
                    <li><a href="${createLink(controller:'userStory', action:'index')}">Stories</a></li>
                    <li><a href="${createLink(controller:'shareYourStory', action:'index')}">Create Story</a></li>
                    <sec:ifNotLoggedIn>
                        <li><a href="${createLink(controller:'user', action:'createAccount')}">Create Account</a></li>
                    </sec:ifNotLoggedIn>
                    <sec:ifAnyGranted roles="ROLE_USER">
                        <li><a href="${createLink(controller:'user', action:'accountDetails')}">Account Details</a></li>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_ADMIN">
                        <li><a href="${createLink(controller:'user', action:'adminDetails')}">Account Details</a></li>
                    </sec:ifAnyGranted>
                    <sec:ifNotLoggedIn>
                        <li><a href="${createLink(controller:'userStory', action:'login')}">Login</a></li>
                    </sec:ifNotLoggedIn>
                    <sec:ifLoggedIn>
                        <li>
                            <a href="${createLink(controller:'logout', action:'index')}">Logout</a>
                        </li>
                    </sec:ifLoggedIn>
                    <sec:ifAnyGranted roles="ROLE_ADMIN">
                        <li>
                            <a href="${createLink(uri:'/')}">Admin Page</a>
                        </li>
                    </sec:ifAnyGranted>

                </ul>
            </div>
        </div>
    </nav>

    <g:layoutBody/>
    %{--<div class="footer" role="contentinfo"></div>--}%
    %{--<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>--}%
    <r:require modules="application"/>
    <r:layoutResources/>
    <style>
        body {
            padding-top: 10px;
            padding-bottom: 40px;
            background: url(http://www.pulsarwallpapers.com/data/media/3/Alien%20Ink%202560X1600%20Abstract%20Background.jpg) top center repeat;
        }
        table, th, td {
            border: 1px solid black;
            background-color: #f5f5f5;
        }
    </style>
</body>
</html>