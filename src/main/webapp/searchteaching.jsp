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
	<h1><span style='color: blue'>Teaching Research </span></h1></br>
	<p>Please indicate the teaching for which you wish to obtain information :</p>
		<table>

			<tr>
				<td><input type="text" id="Name" name="Name" /></td>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>

	</form>
		<form method="GET"  action="index.jsp">
		<table>
			<tr>
				<td><input type="submit" value="Return to Homepage" /></td>
			</tr>
		</table>

	</form>
</body>
</html>