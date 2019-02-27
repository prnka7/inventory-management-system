<%@ page import="com.emxcel.InventoryProduct.model.Product, java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search Result</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>
	<jsp:include page="link.jsp" />
	<p>Found:</p>
	<%
		try {
			Product productDetail = (Product) session.getAttribute("productDetail");
			String name = productDetail.getProduct_name();
	%>

	<table>
		<tr>
			<td>Name:</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td><%=productDetail.getProduct_qty()%></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><%=productDetail.getProduct_price()%></td>
		</tr>
		<tr>
			<td colspan="2"><a
				href="editform.jsp?id=<%=productDetail.getProduct_id()%>">Edit</a></td>
		</tr>
	</table>
	<%
		} catch (NullPointerException e) {
	%>
	<h2>No Product Found!!</h2>
	<%
		}
	%>

</body>
</html>