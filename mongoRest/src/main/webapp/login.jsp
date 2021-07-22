<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<center>
<h2>Login Page</h2>
${SPRING_SECURITY_LAST_EXCEPTION.message }
<form action="login" method="POST">
	<table>
	<tr>
		<td> Username </td>
		<td> <input type='text' name='username'></td>
	</tr>
	<tr>
		<td> Password </td>
		<td> <input type='password' name='password'></td>
	</tr>
	<tr>
		<td></td>
		<td><center> <input type='submit' name='submit' value='submit'></center></td>
	</tr>
	</table>
</center>	
</form>
</body>
</html>