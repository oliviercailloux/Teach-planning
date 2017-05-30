<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Number hours for teacher</title>
	</head>
	<body>
	<b> Déclaration du nombre d'heures de cours :</b><br/><br/>
		<% if(session.getAttribute("typeSession") != null && session.getAttribute("typeSession").equals("admin")) { %>
		<form method="POST" name="addTeacherForm" action="../teacherHours">
	
			<table>
				<tr>
					<td><label for="teacherFirstname">Prénom :<span style="color:red">*</span></label></td>
					<td><input type="text" id="teacherFirstname" name="teacherFirstname" required /></td>
				</tr>
				<tr>
					<td><label for="teacherLastname">Nom :<span style="color:red">*</span></label></td>
					<td><input type="text" id="teacherLastname" name="teacherLastname" required /></td>
				</tr>	
				<tr>
					<td><label for="nbHours">Nombre d'heures :<span style="color:red">*</span></label></td>
					<td><input type="number" id="nbHours" name="nbHours" min="0" required /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Ajouter le nombre d'heures" /></td>
				</tr>
			</table>
		</form>
		<%
			} else if(session.getAttribute("typeSession") != null && session.getAttribute("typeSession").equals("teacher")) {
		%>
		<form method="POST" name="addTeacherForm" action="../teacherHours">
	
			<table>
				<tr>
					<td><label for="nbHours">Nombre d'heures :<span style="color:red">*</span></label></td>
					<td><input type="number" id="nbHours" name="nbHours" min="0" required /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Ajouter le nombre d'heures" /></td>
				</tr>
			</table>
		</form>
		<%
			}
		%>
		<a href="../index.jsp">Rendez-vous à l'index!</a>
	</body>
</html>