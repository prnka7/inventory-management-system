<%@page import="com.emxcel.web.dao.*"%>
<%@page import="com.emxcel.InventoryProduct.model.*"%>
<%@page import="java.util.*"%>
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
	<%
		try {
			boolean update = false, create = false, read = false, delete = false;
			User user = (User) session.getAttribute("loggeduser");
			List<Role> roles = user.getTblRoles();
			for (Role role : roles) {
				List<Permission> permissions = role.getTblPermissions();
				for (Permission permission : permissions) {
					if (permission.getPermissionName().equals("update"))
						update = true;
					if (permission.getPermissionName().equals("create"))
						create = true;
					if (permission.getPermissionName().equals("read"))
						read = true;
					if (permission.getPermissionName().equals("delete"))
						delete = true;
				}
			}
	%>
	<jsp:include page="link.jsp" />
	<form class="searchform" action="searchproduct">
		<input type="text" name="searchid"> <input type="submit"
			value="Search By Id">
	</form>
	
	<hr>
	<%
		if (read) {
	%>
	<table>
		<caption>Product List</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>QUANTITY</th>
				<th>RATE</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody>
			<%
				ProductDAO productDao = new ProductDAO();
						int total = 10;
						String spageid = request.getParameter("page");
						int start = Integer.parseInt(spageid);
						if (start == 1) {
						} else {
							start = start - 1;
							start = start * total + 1;
						}
						//	session.setAttribute("productList",
						List<Product> productList = productDao.getAllProducts(start, total);
						//(List<Product>) session.getAttribute("productList");
						for (Product p : productList) {
			%>
			<tr>
				<td><%=p.getProduct_id()%></td>
				<td><%=p.getProduct_name()%></td>
				<td><%=p.getProduct_qty()%></td>
				<td><%=p.getProduct_price()%></td>
				<td>
					<%
						if (update) {
					%><a href="editform.jsp?id=<%=p.getProduct_id()%>">Edit</a> <%
 	} else {
 %> disable<%
 	}
 %>
				</td>
				<td>
					<%
						if (delete) {
					%><a href="deleteproduct?id=<%=p.getProduct_id()%>">Delete</a> <%
 	} else {
 %> disable<%
 	}
 %>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	Page No
	<%=spageid%>
	<br>

	<br>
	<%
		int pages = productDao.getProductCount() / total;
				if ((productDao.getProductCount() % total) != 0)//odd
					pages++;
				for (int i = 1; i <= pages; i++) {
	%>
	<a  href="product.jsp?page=<%=i%>"><%=i%></a>
	<%
		}
	%>
	<br />
	<br>
	<%
		if (create) {
	%>
	<a href="addProductForm.jsp">Add New Product</a>
	<%
		}
			} else {
	%><h1>
		You are not authorized to see products! <br>Contact Admin!
	</h1>
	<%
		}
		} catch (Exception e) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>
</body>
</html>