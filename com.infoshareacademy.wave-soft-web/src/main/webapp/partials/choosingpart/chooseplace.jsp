<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Wybierz miejsce w samochodzie:</h2>
<form name="chosenplace" method="post" action="findpart">
    <select required name="singleplace">
        <c:forEach var="place" items="${placeInCar}">
            <option value="${place.id}">${place.nameOfPlace}</option>
        </c:forEach>
    </select>
    <button type="submit">Wybierz</button>
</form>

