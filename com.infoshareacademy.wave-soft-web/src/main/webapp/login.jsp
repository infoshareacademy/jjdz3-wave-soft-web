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
                <div class="g-signin2" data-onsuccess="onSignIn" id="signIn"></div>
                <script type="text/javascript">
                    function onSignIn(googleUser) {
                        window.location.href='welcome.jsp';

                        var profile = googleUser.getBasicProfile();
                        var name=profile.getName();
                        var email=profile.getEmail();

                    }
                </script>

navbar-collapse -->
             </div>
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Witaj, na stronie Wave Autparts!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a
            jumbotron and three supporting pieces of content. Use it as a starting point to create something more
            unique.</p>
        <p id="demo" class="collapse">This is a template for a simple marketing or informational website. It includes a large callout called a
            jumbotron and three supporting pieces of content. Use it as a starting point to create something more
            unique. This is a template for a simple marketing or informational website. It includes a large callout called a
            jumbotron and three supporting pieces of content. </p>

        <p><a class="btn btn-primary btn-lg" href="#" role="button" data-toggle="collapse" data-target="#demo">Czytaj dalej &raquo;</a></p>
    </div>
</div>

<div class="container">

    <ul class="nav nav-pills">
        <li role="presentation" class="active"><a href="#">Polski</a></li>
        <li role="presentation"><a href="#">English(US)</a></li>
    </ul>

    <jsp:include page="partials/footer.jsp" />
</div> <!-- /container -->

</body>
</html>