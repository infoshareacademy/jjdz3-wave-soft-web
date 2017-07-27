<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<c:if test="${not empty searchPhrase}">
    <hr>
    <form name="apisearch" method="get" action="ebaysearch">
        <p>Wpisz do wyszukiwarki:<input name="searchPhrase" type="text"value="${searchPhrase}" readonly="readonly"/>
            <button type="submit">Wyszukaj</button>
        </p>
    </form>

    <%--<p>Wpisz do wyszukiwarki: <strong>${searchPhrase}</strong>.</p>--%>
</c:if>
