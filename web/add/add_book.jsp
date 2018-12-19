<%--
  Created by IntelliJ IDEA.
  User: RED
  Date: 18.12.2018
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Create new book:
<form action="AddServlet" method="post">
    <input type="hidden" name="action" value="add_book"/>
    <input type="text" name="book_name" />
    <input type="text" name="author_name" />
    <input type="date" name="date"/>
    <input type="submit" value="add new book"/>
</form>
<input type="button" value="<== Previous page" onclick="history.back()">



</body>
</html>
