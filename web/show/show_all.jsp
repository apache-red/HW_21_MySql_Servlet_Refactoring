<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

Show all data:
<form action="ShowServlet" method="post">
    <input type="hidden" name="action" value="show_all"/>
    <input type="submit" value="Show All Data"/>
</form>
<input type="button" value="<== Previous page" onclick="history.back()">

</body>
</html>
