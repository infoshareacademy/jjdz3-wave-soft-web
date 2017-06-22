<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/meta.jsp" />
    <title>Admin Service</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
        table,th,td
        {
            border:1px solid black;
        }
    </style>
</head>
<body>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1 class="mainHeader">Panel administracyjny Wave Autoparts!</h1>
        <p>Wybierz interesującą Ciebie akcję</p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-6">
            <h2>Statystyki</h2>
            <p>Zobacz którą kategorię najczęściej wybierali użytkownicy</p>
            <p><a class="btn btn-default" href="#" role="button">Więcej &raquo;</a></p>
        </div>
        <div class="col-md-6">
            <h2>Kolejna funkcjonalność</h2>
            <p>Krótki opis kolejnej funkcjonalności</p>
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

<%--<table>--%>
<%--<tbody>--%>
<%--<tr><th>What</th><th>HowManyTimes</th></tr>--%>
<%--<c:forEach items="${requestScope.findPartList}" var="fpl">--%>
    <%--<td><c:out value="${fpl.partName}"></c:out></td></tr>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>
<%--</table>--%>
</body>
</html>
