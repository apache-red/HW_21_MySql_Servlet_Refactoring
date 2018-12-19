<%--
  Created by IntelliJ IDEA.
  User: RED
  Date: 17.12.2018
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Delete book by ID:
<form action="ServletPost" method="post">
    <input type="hidden" name="action" value="delete_book"/>
    <input type="number" name="id_book" />
    <input type="submit" value="delete book by id"/>
</form>
<input type="button" value="<== Previous page" onclick="history.back()">
</body>
</html>
