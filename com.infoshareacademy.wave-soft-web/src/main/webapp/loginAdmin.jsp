<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <jsp:include page="partials/meta.jsp" />
    <title>Admin Service</title>
  </head>
  <body>

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
    <div class="container">
      <h1 class="mainHeader">Witaj, na stronie Wave Autoparts!</h1>
      <p>Pomożemy Ci znaleźć części samochodowe których szukasz na takich serwisach jak Allegro czy Ebay. Wiemy jak czasochłonne i frustrujące
        potrafi być poszukiwanie tego czego szukasz. Pozwól że zrobimy to za Ciebie.</p>

      <script src="resources/mainjs.js"></script>
      <p>Admin service for Wave Autoparts web app</p>
      <form action="adminStuff" method="post">
        <p>${errorMessage}</p>
        Login:<input type="text" name="nameJsp"/>
        Password:<input type="password" name="passwordJsp"/>
        <input type="submit" value="login"/>


    </div>
  </div>

  <div class="container">

    <ul class="nav nav-pills">
      <li role="presentation" class="active"><a href="#">Polski</a></li>
      <%-- <li role="presentation"><a href="#">English(US)</a></li>--%>
    </ul>

    <hr>

    <jsp:include page="partials/footer.jsp" />
  </div> <!-- /container -->


  </form>
  </body>
</html>
