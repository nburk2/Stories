<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/19/14
  Time: 10:49 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>

    <div class="container" style="padding-top: 50px">
        <div class="jumbotron hero-spacer">

            <div id = "myCarousel" class = "carousel slide">
                <ol class = "carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to = "0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to = "1"></li>
                    <li data-target="#myCarousel" data-slide-to = "2"></li>
                </ol>

                <div class ="carousel-inner">
                    <div class="item active">
                        <img src="../images/home/collaborate-and-learn.jpg" alt = "beach" class="img-responsive" style="width:100%">
                        <div class = "carousel-caption">
                            <h3>Collaborate with others in creating personalized stories.</h3>
                        </div>
                    </div>

                    <div class="item">
                        <img src="../images/home/addiction.jpg" alt = "Jweont" class="img-responsive" style="width:100%">
                        <div class = "carousel-caption">
                            <h3>Find help for specific struggles that you are currently facing.</h3>
                        </div>
                    </div>
                    <div class="item">
                        <img src="../images/home/the-truth.png" alt = "What" class="img-responsive" style="width:100%">
                        <div class = "carousel-caption">
                            <h3>Learn the truth about drugs from personalized stories that others have experienced.</h3>
                        </div>
                    </div>
                </div>

                <a class = "carousel-control left" href="#myCarousel" data-slide="prev">
                    <span class="icon-prev"></span>
                </a>
                <a class = "carousel-control right" href="#myCarousel" data-slide="next">
                    <span class="icon-next"></span>
                </a>

            </div>
        </div>
    </div>
    <scriptt src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></scriptt>
    <script src = "../js/bootstrap.js"></script>

    <script>
        $(document).ready(function(){
            $('.carousel').carousel({interval: 4000});
        });
    </script>
</body>
</html>