<html>
	<body>
		<h1>
			<span style='color: blue'>Bienvenue sur Teach Planning app !</span>
		</h1>
		
		<%
			if(session.getAttribute("typeSession") != null) {
		%>

			<form method="GET" name="listandsearch" action="listandsearch">
				<table>
					<tr>
						<td><input type="submit" value="Rechercher les informations sur un enseignement" /></td>
					</tr>
				</table>
			</form>
			
			<form method="GET" name="listandsearch" action="chargeTeacher">
				<table>
					<tr>
						<td><input type="submit" value="Rechercher les informations sur un enseignant" /></td>
					</tr>
				</table>
			</form>
			
			<a href="jsps/prefView/prefForm.jsp">Ajouter les préférences d'un enseignant</a><br/>
			
			<a href="jsps/serviceFile.jsp">Imprimer la fiche de service d'un enseignant</a>
	
		<%		
			} else {
		%>
			<a href="jsps/login.jsp">Connectez-vous pour accéder à cette page!</a>
		<%		
			}
		%>
	
	</body>
</html>
