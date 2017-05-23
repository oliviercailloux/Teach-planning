<!DOCTYPE html>
<html>

	<head>
		<%@ page import="io.github.oliviercailloux.teach_planning.model.Teaching"%>
		<%@ page import="io.github.oliviercailloux.teach_planning.teaching.TeachingServlet"%>
		
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

				<input type="submit" value="Rechercher" />
			</form>
			

			
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