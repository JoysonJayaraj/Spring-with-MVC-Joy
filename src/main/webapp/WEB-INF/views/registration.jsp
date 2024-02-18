<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>http://localhost:8080/employee-management-system/app/auth/register</title>
</head>
<body>
	<fieldset>
		<form action="register" method="post">

			<table border="10">
				<tr>
					<td>Enter employee id :</td>
					<td><input type="text" placeholder="example TY001"
						name="empId"></td>
				</tr>

				<tr>
					<td>Enter employee age :</td>
					<td><input type="text" placeholder="example 22" name="empAge"></td>
				</tr>

				<tr>
					<td>Enter employee email-id :</td>
					<td><input type="email"
						placeholder="example example@example.com" name="empEmail"></td>
				</tr>

				<tr>
					<td>Enter password :</td>
					<td><input type="password" placeholder="example hjbiuf7988"
						name="password"></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit">REGISTER</button></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>