<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<hr>
<h2>Wybierz kategorię części:</h2>
<form name="chosencategory" method="post" action="findpart">
    <select required name="singlecategory">
        <c:forEach var="category" items="${partCategory}">
            <option value="${category.id}">${category.categoryName}</option>
        </c:forEach>
    </select>
    <button type="submit">Wybierz</button>
</form>
</body>
</html>