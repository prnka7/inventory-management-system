<%@page import="java.util.*"%>
<%@page import="com.emxcel.InventoryProduct.model.*"%><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
</head>
<body>



	 <a href="ShowProductController">Show</a>
	<table style="width: 20%;border: 1px solid black;border-collapse: collapse;">
	<tr><th>ID</th>
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