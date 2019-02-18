<%@page import="java.util.*"%>
<%@page import="com.emxcel.InventoryProduct.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
input[type=text]:enabled {
	background: green;
}

input[type=text]:disabled {
	background: white;
}

input {
	width: 150px;
	padding-left: 10px;
	margin-top: 10px;
	border: 1px solid black;
}

body {
	text-align: left;
}
</style>
<body>
	<form name="ProductMenu" action="ProductMenu" method="get">


		<input type="button" value="AddProduct" name="product"
			onclick="openPage('AddProduct.jsp')" />

	</form>
	<script type="text/javascript">
		function openPage(pageURL) {
			window.location.href = pageURL;
		}
	</script>
	<h3>Role List of the User</h3>
	<%
		List<Role> rolelist = (List<Role>) request.getAttribute("rolelist");
		for (Role role : rolelist) {
			switch (role.getRole_name()) {
				case "admin" :
					out.println("User role is " + role.getRole_name());
	%>
	document.getElementById("scan").disabled = true;
	<%
		break;
				case "superadmin" :
					out.println("User role is " + role.getRole_name());
					break;
				case "customer" :
					out.println("User role is " + role.getRole_name());
					break;
				default :
					break;
			}
		}
	%><br>

	</body>
<script>
	function admin() {
	}
</script>
</html>