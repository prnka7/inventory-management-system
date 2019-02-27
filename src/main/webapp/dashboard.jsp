<%@ page import="com.emxcel.InventoryProduct.model.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>

	<%
		if (session.getAttribute("loggeduser") != null) {
			User user = (User) session.getAttribute("loggeduser");
	%>
	<jsp:include page="link.jsp" />

	<h4>
		Welcome,
		<%=user.getUser_name()%></h4>
	<br>

	<%
		boolean read = false;
			List<Role> roles = user.getTblRoles();
			for (Role role : roles) {
				if (role.getRole_name().equals("superadmin"))
					read = true;
			}
			if (read) {
	%>
	<a href="getUser" class="link">User</a>
	<%
		}
		} else {
	%>
	Login first to access the data!
	<a class="button" href="login.jsp">Log In</a>
	<%
		}
	%>

</body>
</html>