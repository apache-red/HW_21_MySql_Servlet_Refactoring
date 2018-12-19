<%--
  Created by IntelliJ IDEA.
  User: RED
  Date: 19.12.2018
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Show all authors:
<form action="ShowServlet" method="post">
    <input type="hidden" name="action" value="show_authors"/>
    <input type="submit" value="Show All authors"/>
</form>
<input type="button" value="<== Previous page" onclick="history.back()">

</body>
</html>
