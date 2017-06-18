<!DOCTYPE HTML>
<html land="pl">
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <jsp:include page="partials/meta.jsp" />

    <title>Wave Soft</title>

</head>


<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" id="navbar-brandID" href="#">Wave Autoparts<span class="glyphicon glyphicon-cog" id="cog" aria-hidden="true"></span></a>
            <!--glyphicon from http://glyphicons.com-->

        </div>
        <div id="navbar" class="navbar-collapse collapse">

            <p id="logOutLink"><a href="logout" class="btn btn-info" role="button">Wyloguj się</a></p>

        </div><!--/.navbar-collapse -->
    </div>
</nav>

<div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
    <!-- Carousel indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Carousel items -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="images/slide1.png" alt="First Slide">
            <div class="carousel-caption">
                <h3>Z nami znajdziesz części których potrzebujesz, namierzymy to czego szukasz!</h3>
            </div>
        </div>
        <div class="item">
            <img src="images/slide2.png" alt="Second Slide">
            <div class="carousel-caption">
                <h3>Byś sam nie tracił na to czasu!</h3>
            </div>
        </div>
        <div class="item">
            <img src="images/slide3.png" alt="Third Slide">
            <div class="carousel-caption">
                <h3>Tak aby pojazd napawał Cię dumą!</h3>
            </div>
        </div>
    </div>
    <!-- Carousel nav -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>



<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1 class="mainHeader">Witaj, na stronie Wave Autoparts!</h1>
        <p>Pomożemy Ci znaleźć części samochodowe których szukasz na takich serwisach jak Allegro czy Ebay. Wiemy jak czasochłonne i frustrujące
            potrafi być poszukiwanie tego czego szukasz. Pozwól że zrobimy to za Ciebie.</p>
        <p id="demo" class="collapse">Aby skorzystać z Naszego serwisu zaloguj się za pomocą konta Google. Prosty w obsłudze formularz pomoże
            znaleźć na Allegro lub Ebay części których potrzebujesz.</p>

        <p><a class="btn btn-primary btn-lg" href="javascript:void(0);" id="more" role="button" data-toggle="collapse" data-target="#demo">Czytaj dalej &raquo;</a></p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-6">
            <h2>Formularz</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">Więcej &raquo;</a></p>
        </div>
        <div class="col-md-6">
            <h2>Kolejna funkcjonalność</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
                porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus.</p>
            <p><a class="btn btn-default" href="#" role="button">Więcej &raquo;</a></p>
        </div>
    </div>

    <hr>

    <ul class="nav nav-pills">
        <li role="presentation" class="active"><a href="#">Polski</a></li>
        <%--<li role="presentation"><a href="#">English(US)</a></li>--%>
    </ul>

    <hr>

    <jsp:include page="partials/footer.jsp" />
</div> <!-- /container -->
<script src="resources/mainjs.js"></script>

</body>
</html>


