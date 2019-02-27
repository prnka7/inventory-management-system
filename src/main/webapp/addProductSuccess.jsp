<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Success</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>
	<jsp:include page="link.jsp" />
	<p>Record successfully saved!</p>
	<jsp:include page="productform.html"></jsp:include>

</body>
</html>