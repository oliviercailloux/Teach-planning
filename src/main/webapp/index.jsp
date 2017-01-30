<html>
	<body>
		<h1>
			<span style='color: blue'>Bienvenue sur Teach Planning app !</span>
		</h1>
		
		<%
			if(session.getAttribute("typeSession") != null) {
		%>
		
			<% if(session.getAttribute("typeSession").equals("admin")) { %>
				<a href="jsps/addTeacher.jsp">Ajouter un enseignant</a><br/>
				<a href="jsps/addTeaching.jsp">Ajouter un enseignement</a><br/>
				<a href="jsps/assignment.jsp">Affecter un enseignant � une mati�re</a><br/>
			<% } %>
			
			<a href="jsps/prefView/prefForm.jsp">Ajouter les pr�f�rences d'un enseignant</a><br/>
			<a href="jsps/EmptyServiceFile.jsp">Imprimer une fiche de service</a><br/>
			<a href="jsps/summaryAssignment.jsp">R�capitulatif des affectations</a><br/>
			<a href="jsps/researchTeaching.jsp">Rechercher les informations sur un enseignement</a><br/>
			<a href="teacherHours">Renseigner les heures d'un enseignant</a><br/>
			
			<form method="POST" name="logoutForm" action="disconnect" style="position:absolute;top:0px;right:0px;">
				<input type="hidden" id="logout" name="logout" value="logout" />
				<input type="submit" value="Se d�connecter" />
			</form>
			
		<%		
			} else {
		%>
			<a href="jsps/login.jsp">Connectez-vous pour acc�der � cette page!</a>
		<%		
			}
		%>
	
	</body>
</html>
