<%@page import="java.util.*"%>
<%@page import="com.emxcel.InventoryProduct.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
	
			alert("Hello");
	
</script>
<%
		List<Role> list = (List<Role>) session.getAttribute("rolelist");
		for(Role role:list)
		{
			
			out.println(role.getRole_name());
			
		}
	%>
</body>
</html>