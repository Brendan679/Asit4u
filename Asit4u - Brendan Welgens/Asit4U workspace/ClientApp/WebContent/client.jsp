<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get User Detail</title>
</head>
<body>
<form action="ClientServlet" method="post">
	<h2>Log in</h2><br/>
	<table>
		<tr>
			<td>Username: </td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td></td>
			<td style="float: right;"><input type="submit" value="Login"/></td>
		</tr>
	</table>

</form>
</body>
</html>