<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="row">
    <div class="col-md-12">
        <h2>Użytkownicy</h2>

        <form name="chosenplace" method="post" action="filteredcategory">
            <select required name="singleplace">
                <c:forEach var="user" items="${listOfusers}">
                    <option value="${user.id}">${user.email}</option>

                </c:forEach>
            </select>
            <select required name="singleplace2">
                <c:forEach var="user" items="${listOfusers}">
                    <option value="${user.id}">${user.firstname}</option>
                </c:forEach>
            </select>
            <select required name="singleplace3">
                <c:forEach var="user" items="${listOfusers}">
                    <option value="${user.id}">${user.lastname}</option>
                </c:forEach>
            </select>
            <select required name="singleplace3">
                <c:forEach var="user" items="${listOfusers}">
                    <option value="${user.id}">${user.entryDate}</option>
                </c:forEach>
            </select>
            <button type="submit">Wybierz</button>
        </form>


                  <table border = "1" width = "100%">
                      <tr>
                          <th>User ID</th>
                          <th>Email</th>
                          <th>Date</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Role</th>
                      </tr>

                      <c:forEach var = "userData" items = "${listOfusers}">
                          <tr>
                              <td><c:out value = "${userData.id}"/></td>
                              <td><c:out value = "${userData.email}"/></td>
                              <td><c:out value = "${userData.entryDate}"/></td>
                              <td><c:out value = "${userData.firstname}"/></td>
                              <td><c:out value = "${userData.lastname}"/></td>
                              <td><c:out value = "${userData.role}"/></td>
                          </tr>
                      </c:forEach>
                  </table>

        <p><a class="btn btn-default" href="#" role="button">Więcej &raquo;</a></p>
    </div>
</div>


</body>
</html>
