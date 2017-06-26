<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="partials/meta.jsp"/>
    <title>Wave Soft - find a part for your car</title>

</head>
<body>
<jsp:include page="partials/view/navbar.jsp"/>


<div class="container">
    <c:if test="${not empty placeInCar}">
        <jsp:include page="partials/choosingpart/chooseplace.jsp">
            <jsp:param name="placeInCar" value="${placeInCar}"/>
        </jsp:include>
    </c:if>
    <c:if test="${not empty partCategory}">
        <jsp:include page="partials/choosingpart/choosecategory.jsp">
            <jsp:param name="partCategory" value="${partCategory}"/>
        </jsp:include>
    </c:if>
    <c:if test="${not empty parts}">
        <jsp:include page="partials/choosingpart/choosepart.jsp">
            <jsp:param name="parts" value="${parts}"/>
            <jsp:param name="searchPhrase" value="${searchPhrase}"/>
        </jsp:include>
    </c:if>
    <jsp:include page="partials/footer.jsp"/>
</div> <!-- /container -->
</body>
</html>
