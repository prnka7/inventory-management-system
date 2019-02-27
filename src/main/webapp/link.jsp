<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>

	<ul>
		<li><a href="dashboard.jsp" class="active">HOME</a></li>
		<li><a href="profile.jsp">PROFILE</a></li>
		<li><a href="product.jsp?page=1">PRODUCT</a></li>
		<li><a href="logout">LOGOUT</a></li>

	</ul>

</body>
</html>