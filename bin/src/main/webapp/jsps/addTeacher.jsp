<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Teach Planning app - Add a teacher</title>
	</head>
	
	<body>
		
		<h1>Teach Planning app</h1>
		
		<%
			if(session.getAttribute("typeSession") != null && session.getAttribute("typeSession").equals("admin")) {
		%>
		
			<h2>Ajouter un nouvel enseignant</h2>
			
			<i>NB : L'email de l'enseignant lui servira de login.
			De plus, le mot de passe est "default". Il devra être modifié à la 1ère connexion.</i>
			
			<form method="POST" name="addTeacherForm" action="../addNewTeacher">
	
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
						<td><label for="teacherEmail">Email :<span style="color:red">*</span></label></td>
						<td><input type="text" id="teacherEmail" name="teacherEmail" required /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Ajouter un enseignant" /></td>
					</tr>
				</table>
		
			</form>
			
			<form method="POST" name="logoutForm" action="../disconnect" style="position:absolute;top:0px;right:0px;">
				<input type="hidden" id="logout" name="logout" value="logout" />
				<input type="submit" value="Se déconnecter" />
			</form>
			
		<%
			} else if(session.getAttribute("typeSession") != null && session.getAttribute("typeSession").equals("teacher")) {
		%>
			<h2>En tant que professeur vous n'êtes pas autorisé à accéder à cette page !</h2>
			
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