<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<hr>
<h2>Wybierz część:</h2>
<form name="chosenpart" method="post" action="findpart">
    <select required name="singlepart">
        <c:forEach var="part" items="${parts}">
            <option value="${part.id}">${part.partId}</option>
        </c:forEach>
    </select>
    <button type="submit">Wybierz</button>
</form>
<hr>
<c:if test="${not empty searchPhrase}">
        <p>Wpisz do wyszukiwarki: <strong>${searchPhrase}</strong>.</p>
</c:if>
</body>
</html>