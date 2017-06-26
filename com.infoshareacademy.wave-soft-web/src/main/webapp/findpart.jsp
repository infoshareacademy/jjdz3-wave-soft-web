<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<c:if test="${not empty placeInCar}">
    <jsp:include page="partials/chooseplace.jsp">
        <jsp:param name="placeInCar" value="${placeInCar}"/>
    </jsp:include>
</c:if>
<c:if test="${not empty partCategory}">
    <jsp:include page="partials/choosecategory.jsp">
        <jsp:param name="partCategory" value="${partCategory}"/>
    </jsp:include>
</c:if>
<c:if test="${not empty parts}">
    <jsp:include page="partials/choosepart.jsp">
        <jsp:param name="parts" value="${parts}"/>
        <jsp:param name="searchPhrase" value="${searchPhrase}"/>
    </jsp:include>
</c:if>


</body>
</html>
