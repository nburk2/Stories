<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/13/14
  Time: 2:08 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>

    <style>
    .page-wrapper {
        margin: 25px;
    }

    div .border{
        border: 1px solid black;
    }

   .well{
       margin-top: 20px;
   }
    </style>
</head>

<body>
<div class="page-wrapper">
    <div class="row">
        <div class="col-sm-10">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h1 class="panel-title">
                        This is a panel
                    </h1>
                </div>

                <div class="panel-body">
                    <div class="col-md-2 hidden-xs hidden-sm">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h1 class="panel-title">
                                    This is a panel
                                </h1>
                            </div>

                            <div class="panel-body">
                                <span>
                                    This is the content inside a panel.
                                </span>
                                <g:each in="${1..10}" var="i">
                                    <span>This is some more text.</span>
                                </g:each>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 pull-right">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <h1 class="panel-title">
                                    This is a panel
                                </h1>
                            </div>

                            <div class="panel-body">
                                <span>
                                    This is the content inside a panel.
                                </span>
                                <g:each in="${1..10}" var="i">
                                    <span>This is some more text.</span>
                                </g:each>
                                <br/>
                                <button class="btn btn-lg btn-success">Click Me</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" This is a lot of text This is a lot of text v. This is a lot of text>
        <div class="col-md-3"><div class="well">This is a lot of text. This is a lot of text. This is a lot of text. This is a lot of text. This is a lot of text</div></div>
        <div class="col-md-6">sdfgdsf</div>
        <div class="col-md-3">dsfgfsd</div>
    </div>
</div>
</body>
</html>