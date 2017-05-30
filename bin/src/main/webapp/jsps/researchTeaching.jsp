<!DOCTYPE html>
<html>

	<head>
		<%@ page import="io.github.oliviercailloux.teach_planning.model.Teaching"%>
		
		<meta charset="UTF-8">
		<title>Teach Planning app - Research a teaching</title>
	</head>
	
	<body>
		
		<h1>Teach Planning app</h1>
		
		<%
			if(session.getAttribute("typeSession") != null) {
		%>
	
			<h2>Rechercher les informations concernant une mati�re</h2>
		
			<form method='GET' name='searchTeaching' action='../searchTeaching'>
				<label for="teaching">Mati�re : <span style="color: red">*</span></label>

				<input type="submit" value="Rechercher" />
			</form>
			

			
			<a href="../index.jsp">Rendez-vous � l'index!</a>
		
			<form method="POST" name="logoutForm" action="../disconnect" style="position:absolute;top:0px;right:0px;">
				<input type="hidden" id="logout" name="logout" value="logout" />
				<input type="submit" value="Se d�connecter" />
			</form>
	
		<%		
			} else {
		%>
			<a href="login.jsp">Connectez-vous pour acc�der � cette page!</a>
		<%		
			}
		%>
	
	</body>
	
</html>