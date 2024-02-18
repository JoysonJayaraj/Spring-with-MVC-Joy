<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Form</title>
</head>
<%
String message = (String) request.getAttribute("message");
%>

<body>
<% if(message != null) { %>
<h1> <%= message %> </h1>
<% } %>
	<fieldset>
		<form action="delete" method="post">
			<table border="10">
				<tr>
					<td>Employee ID: </td>
					<td><input type="text" placeholder="example TY001"
						name="empId"></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit">Delete</button></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>