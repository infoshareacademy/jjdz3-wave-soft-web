<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Admin Service</title>
  </head>
  <body>
  <p>Admin service for Wave Autoparts web app</p>
  <form action="adminStuff" method="post">
    <p>${errorMessage}</p>
    Login:<input type="text" name="nameJsp"/>
    Password:<input type="password" name="passwordJsp"/>
              <input type="submit" value="login"/>

  </form>
  </body>
</html>
