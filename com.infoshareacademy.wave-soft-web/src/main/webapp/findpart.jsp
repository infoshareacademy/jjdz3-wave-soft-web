
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<jsp:include page="partials/chooseplace.jsp">
    <jsp:param name="placeInCar" value="${placeInCar}" />
</jsp:include>



</body>
</html>
