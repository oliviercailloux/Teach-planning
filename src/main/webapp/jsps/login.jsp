<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Teach Planning app - Log In</title>
	</head>
	
	<body>
		
		<h1>Teach Planning app</h1>
		
		<%
			if(session.getAttribute("errorLogin") != null) {
		%>
			<p style="color:red"><%= session.getAttribute("errorLogin") %></p>
		<%
			session.setAttribute("errorLogin", null);
			}
		%>
		
		<%
			if(session.getAttribute("typeSession") != null && session.getAttribute("typeSession").equals("admin")) {
		%>
		
			<h2>Vous êtes connecté en tant qu'administrateur !</h2>
			
			<a href="addTeacher.jsp">Ajouter un nouvel enseignant</a><br/>
			<a href="addTeaching.jsp">Ajouter un nouvel enseignement</a><br/>
			<a href="prefView/prefForm.jsp">Ajouter les préférences d'un enseignant</a><br/>
			<a href="serviceFile.jsp">Imprimer la fiche de service d'un enseignant</a><br/>
			<a href="../chargeTeacher">Rechercher les informations sur un enseignant</a><br/>
			<a href="../listandsearch">Rechercher les informations sur un enseignement</a><br/>
			<a href="../teacherHours">enseigner les heures d'un enseignant</a>
			
			<form method="POST" name="logoutForm" action="../disconnect">
	
				<table>
					<tr>
						<td><input type="hidden" id="logout" name="logout" value="logout" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Se déconnecter" /></td>
					</tr>
				</table>
		
			</form>
		<%
			} else if(session.getAttribute("typeSession") != null && session.getAttribute("typeSession").equals("teacher")) {
		%>
			<h2>Vous êtes connecté en tant que professeur !</h2>
			
			<a href="../index.jsp">Rendez-vous à l'index!</a>
			
			<form method="POST" name="logoutForm" action="../disconnect">
	
				<table>
					<tr>
						<td><input type="hidden" id="logout" name="logout" value="logout" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Se déconnecter" /></td>
					</tr>
				</table>
		
			</form>
		<%
			} else {
		%>
		
			<h2>Connectez-vous !</h2>
			
			<i>NB : L'email sert de login.
			De plus, le mot de passe est "default" à la 1ère connexion. Il doit être modifié.</i>
			
			<form method="POST" name="loginForm" action="../connect">
	
				<table>
					<tr>
						<td><label for="login">Login :<span style="color:red">*</span></label></td>
						<td><input type="text" id="login" name="login" required /></td>
					</tr>
					<tr>
						<td><label for="password">Mot de passe :<span style="color:red">*</span></label></td>
						<td><input type="password" id="password" name="password" required /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Se connecter" /></td>
					</tr>
				</table>
		
			</form>
		<%
			}
		%>
	</body>
	
</html>