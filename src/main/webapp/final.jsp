<%@page import="java.util.*"%>
<%@page import="com.emxcel.InventoryProduct.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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





	<br>
<body>



	<ul>
		<li><a class="active" href="#home">Home</a></li>
		<li><a href="listrole" id="link1">Profile</a></li>
		<li><a href="ShowProductController">Events</a></li>
		<li><a href="logout">Logout</a></li>
	</ul>

</body>

</html>