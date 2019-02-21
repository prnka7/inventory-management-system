<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Record</title>
</head>
<body>
Enter an exsiting Id to delete Record<br><br>
<form action="removeproduct">
<table><tr><td>
<input type="text" name="getid"></td><td>
<input type="submit" value="Delete" name="Delete" onClick="popUps()"></td></tr>
</table>
</form>
<script>
function popUps() {
			window.alert("Data Removed to Database");
			window.location.reload();
		}
	</script>
</body>
</html>