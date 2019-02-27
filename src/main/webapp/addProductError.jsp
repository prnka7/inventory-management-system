<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Error</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>
	<jsp:include page="link.jsp" />
	<p>Sorry, an error occurred!</p>
	<jsp:include page="productform.html"></jsp:include>

</body>
</html>