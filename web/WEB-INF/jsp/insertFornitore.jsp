<%--
  Created by IntelliJ IDEA.
  User: manuel
  Date: 11/08/15
  Time: 14.37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

  <form action="insertFornitore" method="post">
    <label>Nome</label><input type="text" name="nomeFornitore">
    <label>Partita Iva</label><input type="text" name="partitaIvaFornitore">
    <input type="submit" value="Invia">
  </form>

  <% String message = (String)request.getAttribute("error"); %>
  <%= message %>
</body>
</html>
