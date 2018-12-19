<%--
  Created by IntelliJ IDEA.
  User: RED
  Date: 17.12.2018
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Edit book title by id:
<form action="ServletPost" method="post">
    <input type="hidden" name="action" value="edit_book_title"/>
    <input type="text" name="book_name" />
    <input type="number" name="id_book" />
    <input type="submit" value="edit book "/>
</form>
<input type="button" value="<== Previous page" onclick="history.back()">
</body>
</html>
