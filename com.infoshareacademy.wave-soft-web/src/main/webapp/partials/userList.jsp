<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="meta.jsp" />
    <title>User List</title>
</head>
<body>

        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <h2>Użytkownicy</h2>

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
                              <td><c:out value = "${userData.role}"/></td>
                          </tr>
                      </c:forEach>
                  </table>

                </div>
            </div>
        </div>

</body>
</html>
