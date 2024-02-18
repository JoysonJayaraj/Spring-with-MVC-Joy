<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<% String message = (String) request.getAttribute("message"); %>
<body>
<% if(message != null) { %>
<h1> <%= message %> </h1>
<% } %>
	<fieldset>
		<form action="resetPassword" method="post">
			<table border="10">
				<tr>
					<td>Enter employee ID:</td>
					<td><input type="text" placeholder="emp001" name="empId"></td>
				</tr>

				<tr>
					<td>Enter old password:</td>
					<td><input type="password" placeholder="ijbvsd"
						name="oldPassword"></td>
				</tr>
				
				<tr>
					<td>Enter new password:</td>
					<td><input type="password" placeholder="erfvfsv"
						name="newPassword"></td>
				</tr>

				<tr>
					<td>Re-enter password:</td>
					<td><input type="password" placeholder="erfvfsv"
						name="retypePassword"></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit">Reset</button></td>
				</tr>
			</table>
		</form>

	</fieldset>

</body>
</html>