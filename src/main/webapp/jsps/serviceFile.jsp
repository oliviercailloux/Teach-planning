<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Teach Planning app - Generate Teacher Service File</title>
	</head>
	
	<body>
		
		<h1>Teach Planning app</h1>
		
		<%
			if(session.getAttribute("typeSession") != null) {
		%>
		
			<h2>Fiche de service de l'enseignant : </h2>
			
			<form method="POST" name="serviceFileForm" action="../serviceFile">
	
				<table>
					
					<tr>
						<td><label for="civ">Civilité : <span style="color:red">*</span></label></td>
						<td>
							<select name="civ" id="civ">
	        					<option value="M." selected="selected" >M.</option>
	        					<option value="Mme." >Mme.</option>
	    					</select>
							<!--<input type="text" id="civ" name="civ" required />-->
						</td>
					</tr>
					<tr>
						<td><label for="teacherName">Nom : <span style="color:red">*</span></label></td>
						<td><input type="text" id="teacherName" name="teacherName" required /></td>
					</tr>
					<tr>
						<td><label for="teacherFirstname">Prénom : <span style="color:red">*</span></label></td>
						<td><input type="text" id="teacherFirstname" name="teacherFirstname" required /></td>
					</tr>
					<tr>
						<td><label for="status">Statut : <span style="color:red">*</span></label></td>
						<td>
							<select name="status" id="status">
	        					<option value="MCF" selected="selected" >MCF</option>
	        					<option value="CTD" >CTD</option>
	        					<option value="VAC" >VAC</option>
	    					</select>
							<!--<input type="text" id="status" name="status" required />-->
						</td>
					</tr>
					<tr>
						<td><label for="teachingSub">Discipline : <span style="color:red">*</span></label></td>
						<td><input type="text" id="teachingSub" name="teachingSub" required /></td>
					</tr>
					<tr>
						<td><label for="mail">E-mail : <span style="color:red">*</span></label></td>
						<td><input type="text" id="mail" name="mail" required /></td>
					</tr>															
					<tr>
						<td></td>
						<td><input type="submit" value="Générer la fiche de service" /></td>
					</tr>
				</table>
		
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