<!DOCTYPE html>
<html>

	<head>
		<%@ page import="teach_planning.teaching.AssignmentServlet" %>
		<%@ page import="teach_planning.teaching.Assignment" %>
	
		<meta charset="UTF-8">
		<title>Teach Planning app - Summary of assignments</title>
	</head>
	
	<body>
	
		<h1>Teach Planning app</h1>
	
		<%
			if(session.getAttribute("typeSession") != null) {
		%>
		
			<h2>Recapitulatif des affectation</h2>
			
			<table border="1">
				<thead>
					<tr>
						<th>Nom Enseignant</th>
						<th>Prenom Enseignant</th>
						<th>Matière</th>
						<th>Type enseignement</th>
						<th>Promotion</th>
					</tr>
				</thead>
				<tbody>
					<% for(Assignment assignment: AssignmentServlet.listAssignation) { %>
						<tr>
							<td><%out.print(assignment.getTeacher().getLastname());%></td>
							<td><%out.print(assignment.getTeacher().getFirstname());%></td>
							<td><%out.print(assignment.getTeaching().getName());%></td>
							<td><%out.print(assignment.getTeachingType());%></td>
							<td><%out.print(assignment.getPromotion());%></td>
						</tr>
					<% } %>
				</tbody>	
			</table>
			
			<% if(session.getAttribute("typeSession").equals("admin")) { %>
				<a href="assignment.jsp">Faire une affectation</a><br/>
			<% } %>
			
			<a href="../index.jsp">Rendez-vous à l'index!</a>
			
			<form method="POST" name="logoutForm" action="../disconnect" style="position:absolute;top:0px;right:0px;">
				<input type="hidden" id="logout" name="logout" value="logout" />
				<input type="submit" value="Se déconnecter" />
			</form>
		
		<%		
			} else {
		%>
			<a href="login.jsp">Connectez-vous pour accéder à cette page!</a>
		<%		
			}
		%>
		
	</body>
	
</html>