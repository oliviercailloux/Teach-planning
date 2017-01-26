<!DOCTYPE html>
<html>

	<head>
	<%@ page import="teach_planning.teaching.AssignmentServlet" %>
	<%@ page import="teach_planning.teaching.Assignment" %>
		<meta charset="UTF-8">
		<title>Teach Planning app - Summary assignment</title>
	</head>
	
	<body>
		
		<h1>Recapitulatif des affectation</h1>
		
				<table border="1">
					<thead>
						<tr>
							<th>Enseignant</th>
							<th>Matière</th>
							<th>Type enseignement</th>
							<th>Promotion</th>
						</tr>
					</thead>
					<tbody>
						<%
						for(Assignment assignment: AssignmentServlet.listAssignation){
						%>
						<tr>
							<td><%out.print(assignment.getNomEnseignant());%></td>
							<td><%out.print(assignment.getMatière());%></td>
							<td><%out.print(assignment.getTypeEnseignement());%></td>
							<td><%out.print(assignment.getPromotion());%></td>
						</tr>
						<% }%>
					</tbody>
					
				</table>
				
				<a href = "assignment.jsp">Faire une autre affectation</a>
	</body>
	
</html>