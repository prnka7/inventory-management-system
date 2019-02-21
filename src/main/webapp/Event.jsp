<%@page import="java.util.*"%>
<%@page import="com.emxcel.InventoryProduct.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	fonr-color: black;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li
a
:hover
:not
(
.active
)
{background-color:#111;
}.active {
	background-color: #4CAF50;
}
</style>

</head>
<body>

	<ul>
		<li><a class="active" href="#view">Product</a></li>
		<li><a href="AddProduct.jsp" id="link1">Add </a></li>
		<li><a href="DeleteProduct.jsp">Delete</a></li>
		<li><a href="UpdateProduct.jsp">Update</a></li>
	</ul>

Product Details
<table
		style="width: 20%; border: 1px solid black; border-collapse: collapse;">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
			List<Product> listp = (List<Product>) request.getAttribute("listp");
			for (Product p : listp) {
		%>
		<tr>
			<td><%=p.getProduct_id()%></td>
			<td><%=p.getProduct_name()%></td>
			<td><%=p.getProduct_price()%></td>
			<td><%=p.getProduct_qty()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>