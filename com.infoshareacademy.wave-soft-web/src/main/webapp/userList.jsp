<!DOCTYPE HTML>
<html land="pl">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="partials/meta.jsp" />
    <title>User List</title>
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
        <p>Za pomocą tego panelu możesz nadać lub zabrać uprawnienia administratora użytkownikom.</p>
    </div>
</div>

        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <h2 id="customH2">Użytkownicy</h2>

                  <table border = "1" width = "80%" class="table">
                      <thead class="thead-inverse">
                      <tr>
                          <th>User ID</th>
                          <th>Email</th>
                          <th>Date</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Role</th>
                      </tr>
                      </thead>

                      <c:forEach var = "userData" items = "${listOfusers}">
                          <tr>
                              <td><c:out value = "${userData.id}"/></td>
                              <td><c:out value = "${userData.email}"/></td>
                              <td><c:out value = "${userData.entryDate}"/></td>
                              <td><c:out value = "${userData.firstname}"/></td>
                              <td><c:out value = "${userData.lastname}"/></td>
                              <td><c:choose>
                                      <c:when test="${userData.role=='1'}">Admin
                                      </c:when>
                                      <c:otherwise>User
                                      </c:otherwise>
                                  </c:choose>

                                  <form action="" id="userRoleForm">

                                      <select required name="userRole" data-width="80px" class="selectpicker" id="inlineFormCustomSelect" form="userRoleForm">
                                          <option selected>Wybierz</option>
                                          <option value="admin">Admin</option>
                                          <option value="user">User</option>
                                      </select>

                                      <button type="submit" class="btn btn-primary">Zachowaj</button>
                                  </form>
                              </td>



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
