<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/18/14
  Time: 10:39 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>

<div class="container" style="padding: 50px">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="panel-title">
                Create your account!
            </div>
        </div>
        <div class="panel-body">
            <div class="col-md-8">
                <form role="form" action="index" method="post">
                    <div class="form-group">
                        <label for="fName">First name</label>
                        <input type="text" class="form-control" required="" name="fName" id="fName" placeholder="first name">
                    </div>
                    <div class="form-group">
                        <label for="lName">Last name</label>
                        <input type="text" class="form-control" required="" name="lName" id="lName" placeholder="last name">
                    </div>
                    <div class="form-group">
                        <label for="username">UserName</label>
                        <input type="text" class="form-control" required="" name="username" id="username" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input type="email" class="form-control" required="" name="email" id="email" placeholder="email">
                    </div>
                    <div class="form-group">
                        <label for="password1">Password</label>
                        <input type="password" class="form-control" required="" name="password1" id="password1" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="password2">Confirm Password</label>
                        <input type="password" class="form-control" required="" name="password2" id="password2" placeholder="Confirm Password">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
            <div class="col-md-4">
                <p>*Please provide a response for all entries.</p>
                <hr/>
                <p>Your on your way to creating an account so that you can share and comment on other people
                personal stories.</p>
            </div>
        </div>
    </div>
</div>

</body>
</html>