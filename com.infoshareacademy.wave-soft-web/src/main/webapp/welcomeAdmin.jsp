<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
Hi ${adminLogin} your password is ${adminPassword}

<table>
<tbody>
<tr><th>ID</th><th>What</th><th>HowManyTimes</th></tr>
<c:forEach items="${requestScope.findPartList}" var="fpl">
    <td><c:out value="${fpl.partName}"></c:out></td></tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
