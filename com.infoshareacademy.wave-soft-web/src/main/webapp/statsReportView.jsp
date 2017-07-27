<!DOCTYPE HTML>
<html land="pl">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<html>
<head>
    <jsp:include page="partials/meta.jsp" />
    <title>Stats Report</title>
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

            <p id="logOutLink"><a href="logout" class="btn btn-info" role="button">Powrót</a></p>

        </div><!--/.navbar-collapse -->
    </div>
</nav>
<div class="jumbotron" id="customJumbotron">
    <div class="container">
        <h1 class="mainHeader">Witaj, administratorze!</h1>
        <p>Statystyki dotyczące wypełniania formularza przez użytkowników</p>
    </div>
</div>

<div class="container">

    <div class="row">
        <div class="col-md-12">
            <h2 id="customH2">Statystyki</h2>

            <table border = "1" width = "80%" class="table">
                <thead class="thead-inverse">
                <tr>
                    <th>ID</th>
                    <th>Date</th>
                    <th>User</th>
                    <th>Part ID</th>
                    <th>Part Category ID</th>
                    <th>Place In Car ID</th>
                </tr>
                </thead>

                <c:forEach var = "report" items = "${reportTable}">
                    <tr>
                        <td><c:out value = "${report.categoryId}"/></td>
                        <td><c:out value = "${report.newDate}"/></td>
                        <td><c:out value = "${report.who}"/></td>
                        <td><c:out value = "${report.persistencePart.id}"/></td>
                        <td><c:out value = "${report.persistencePartCategory.id}"/></td>
                        <td><c:out value = "${report.persistencePlaceInCar.id}"/></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
    <hr>

    <ul class="nav nav-pills">
        <li role="presentation" class="active"><a href="#">Polski</a></li>
        <%--<li role="presentation"><a href="#">English(US)</a></li>--%>
    </ul>

    <hr>

    <jsp:include page="partials/footer.jsp" />
</div>

<script src="resources/mainjs.js"></script>
</body>
</html>
