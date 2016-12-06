<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Research a teaching</title>
</head>
<body>
	<form method="GET" name="searchTeaching" action="searchTeaching">
		<table>
			<tr>
				<td><label for="Name"> <span style="color: violet">*</span></label></td>
				<td><input type="text" id="Name" name="Name" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>

	</form>
</body>
</html>