<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manange</title>
</head>
<body>
<h3>Manager Your Inventory</h3>
<form action="">
	<table><tr><td><input type="button" value="AddProduct" name="add"
			onclick="openPage('AddProduct.jsp')" /></td></tr></table></form>
		<script type="text/javascript">
		function openPage(pageURL) {
			window.location.href = pageURL;
		}
	</script>	
</body>
</html>