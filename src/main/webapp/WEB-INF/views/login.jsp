<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<%
String message = (String) request.getAttribute("message");
%>

<body>
<% if(message != null) { %>
<h1> <%= message %> </h1>
<% } %>
	<fieldset>
		<form action="login" method="post">
			<table border="10">
				<tr>
					<td>Employee ID:</td>
					<td><input type="text" placeholder="example TY001"
						name="empId"></td>
				</tr>

				<tr>
					<td>Enter Password :</td>
					<td><input type="password" placeholder="abc@gmail.com"
						name="password"></td>
				<tr>
					<td></td>
					<td><button type="submit">Login</button></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>