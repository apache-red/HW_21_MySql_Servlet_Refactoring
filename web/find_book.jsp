<%--
  Created by IntelliJ IDEA.
  User: RED
  Date: 17.12.2018
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
find book by title
<form action="ServletPost" method="post">
    <input type="hidden" name="action" value="find_book_title"/>
    <input type="text" name="book_name" />
    <input type="submit" value="edit book "/>
</form>
</body>
</html>
