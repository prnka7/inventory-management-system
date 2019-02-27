<%@ page import="com.emxcel.InventoryProduct.model.*"
	import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>
	<jsp:include page="link.jsp" />

	<%
		try {
			User user = (User) session.getAttribute("loggeduser");
			Date createTime = new Date(session.getCreationTime());
			// Get last access time of this Webpage.
			Date lastAccessTime = new Date(session.getLastAccessedTime());
	%><h3>
		Hello,
		<%=  user.getUser_name().toUpperCase() %>. Welcome to this Application. <br>

	</h3>

	<h2>
		Role :
		<%
		List<Role> roleList = user.getTblRoles();
			for (Role role : roleList) {
	%>
		<%=role.getRole_name()%>
	</h2>

	<table id="table-1">
		<tbody>
			<tr>
				<th>Created time:</th>
				<td><%=createTime%>
				<td>
			</tr>
			<tr>
				<th>Session Id</th>
				<td><%=session.getId()%></td>

			</tr>
			<tr>
				<th>Time interval</th>
				<td><%=session.getMaxInactiveInterval()%></td>

			</tr>
			<tr>
				<th>Last Access Time</th>
				<td><%=lastAccessTime%></td>
			</tr>
		</tbody>
	</table>
	<%
		}
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
	%>
</body>