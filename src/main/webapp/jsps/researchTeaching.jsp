<!DOCTYPE html>
<html>

	<head>
		<%@ page import="teach_planning.teaching.Teaching"%>
		<%@ page import="teach_planning.teaching.TeachingServlet"%>
		
		<meta charset="UTF-8">
		<title>Teach Planning app - Research a teaching</title>
	</head>
	
	<body>
		
		<h1>Teach Planning app</h1>
		
		<%
			if(session.getAttribute("typeSession") != null) {
		%>
	
			<h2>Rechercher les informations concernant une matière</h2>
		
			<form method='GET' name='searchTeaching' action='../searchTeaching'>
				<label for="teaching">Matière : <span style="color: red">*</span></label>
				<select name="teaching" id="teaching" required>
				<% for (int j=0; j<TeachingServlet.teachingList.size(); j++) { %>
					<option value="<% out.print(j); %>"><% out.print(TeachingServlet.teachingList.get(j).getName()); %></option>
				<% } %>
				</select>
				<input type="submit" value="Rechercher" />
			</form>
			
			<% if(session.getAttribute("indexTeaching") != null && session.getAttribute("indexTeaching") != "") { %>
				<p><% out.print(TeachingServlet.teachingList.get((Integer) session.getAttribute("indexTeaching")).toString()); %></p>
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