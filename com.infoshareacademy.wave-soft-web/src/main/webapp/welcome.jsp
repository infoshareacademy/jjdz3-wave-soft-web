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
            <a class="navbar-brand" href="#">Wave Autoparts</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">

            <script>
                function signOut() {
                    var auth2 = gapi.auth2.getAuthInstance();
                    auth2.signOut().then(function () {
                        console.log('User signed out.');
                        window.location.href='login.jsp';
                    });
                }
                function onLoad() {
                    gapi.load('auth2', function() {
                        gapi.auth2.init();
                    });
                }
            </script>
            <p id="logOutLink"><a href="#" onclick="signOut();" class="btn btn-info" role="button" >Wyloguj się</a></p>

            <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>

        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Witaj</h1>

        <p>This is a template for a simple marketing or informational website. It includes a large callout called a
            jumbotron and three supporting pieces of content. Use it as a starting point to create something more
            unique.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button" >Czytaj dalej &raquo;</a></p>
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
        <li role="presentation"><a href="#">English(US)</a></li>
    </ul>

    <jsp:include page="partials/footer.jsp" />
</div> <!-- /container -->

</body>
</html>


