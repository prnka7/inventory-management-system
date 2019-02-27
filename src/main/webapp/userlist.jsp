<%@ page import="com.emxcel.InventoryProduct.model.*" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>
	<jsp:include page="link.jsp" />

	<table class="table1">
		<caption>Users List</caption>
		<thead>
			<tr>
				<th>NAME</th>
				<th>ROLE</th>
				<th>PERMISSION</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<User> userlist = (List<User>) session.getAttribute("user");
				for (User user : userlist) {
					List<Role> rolelist = user.getTblRoles();
					for (Role o : rolelist) {
						List<Permission> permissionlist = o.getTblPermissions();
			%>
			<tr>
				<td><%=user.getUser_name()%></td>

				<td><%=o.getRole_name()%></td>

				<td>
					<%
						for (Permission p : permissionlist) {
					%> <%=p.getPermissionName()%> <br> <%
 	}
 		}
 	}
 %>


				</td>
			</tr>

		</tbody>
	</table>

</body>
</html>