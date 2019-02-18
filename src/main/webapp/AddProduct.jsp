<%@page import="com.emxcel.InventoryProduct.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductList</title>
</head>
<body bgcolor="lightblue">
	<h1>Inventory Management</h1>
	<br>
	<h3>Product</h3>
	<form action="addproduct">
		<table>
			<tr>
				<td>Product ID: &nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
					name="getid"></td>
			</tr>
			<tr>
				<td>Product Name: <input type="text" name="getname"></td>
			</tr>
			<tr>
				<td>Product Price: <input type="text" name="getprice">
				</td>
			</tr>
			<tr>
				<td>Product Quantity: <input type="text" name="getquantity">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Product" onClick="popUps()"
					></td>
			</tr>
		</table>
	</form>

	<form name="ProductMenu" action="ProductMenu" method="get">


		<input type="button" value="ShowProduct" name="showProduct"
			onclick="ShowProductController" /> <a href="ShowProductController">Show</a>
	</form>
	<script type="text/javascript">
		function openPage(pageURL) {
			window.location.href = pageURL;
		}

		function popUps() {
			window.alert("Data added to Database");
			window.location.reload();
		}
	</script>
	<%
		
	%>
</body>
</html>