<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Create new author:
<form action="AddServlet" method="post">
	<input type="hidden" name="action" value="add_author"/>
	<input type="date" name="date"/>
	<input type="text" name="author_name"/>
	<input type="submit" value="add new author"/>
</form>
<input type="button" value="<== Previous page" onclick="history.back()">


</body>
</html>