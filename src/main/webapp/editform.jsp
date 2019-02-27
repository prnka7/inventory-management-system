<%@page import="com.emxcel.web.dao.*,com.emxcel.InventoryProduct.model.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>
	<jsp:include page="link.jsp" />
	<br>
	<%
		ProductDAO productDao = new ProductDAO();
		Long id = Long.parseLong(request.getParameter("id"));
		Product product = productDao.getProduct(id);
	%>

	<h1>Edit Form</h1>
	<form action="editproduct" method="post">
		<input type="hidden" name="id" value="<%=product.getProduct_id()%>" />
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"
					value="<%=product.getProduct_name()%>" /></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><input type="text" name="quantity"
					value="<%=product.getProduct_qty()%>" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price"
					value="<%=product.getProduct_price()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit Product" /></td>
			</tr>
		</table>
	</form>

</body>
</html>