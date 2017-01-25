<html>
	<body>
		<h1>
			<span style='color: blue'>Bienvenue sur Teach Planning app !</span>
		</h1>
		
		<%
			if(session.getAttribute("typeSession") != null) {
		%>
			<ul>
				<li><a href="jsps/addTeacher.jsp">Ajouter un nouvel enseignant</a></li>
				<li><a href="jsps/addTeaching.jsp">Ajouter un nouvel enseignement</a></li>
				<li><a href="jsps/prefView/prefForm.jsp">Ajouter les préférences d'un enseignant</a></li>
				<li><a href="jsps/serviceFile.jsp">Imprimer la fiche de service d'un enseignant</a></li>
				<li><a href="chargeTeacher">Rechercher les informations sur un enseignant</a></li>
				<li><a href="listandsearch">Rechercher les informations sur un enseignement</a></li>
				<li><a href="teacherHours">Renseigner les heures d'un enseignant</a></li>
			</ul>
		<%		
			} else {
		%>
			<a href="jsps/login.jsp">Connectez-vous pour accéder à cette page!</a>
		<%		
			}
		%>
	
	</body>
</html>
