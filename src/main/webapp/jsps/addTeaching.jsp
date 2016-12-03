<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Teach Planning app - Add a teaching</title>
	</head>
	
	<body>
		
		<h1>Teach Planning app</h1>
		
		<h2>Ajouter un nouvel enseignement</h2>
		
		<form method="POST" name="addTeachingForm" action="../addNewTeaching">

			<table>
				<tr>
					<td><label for="teachingName">Enseignement : <span style="color:red">*</span></label></td>
					<td><input type="text" id="teachingName" name="teachingName" required /></td>
				</tr>
				<tr>
					<td><label for="CM">Nombre d'heures de cours magistraux (CM) :</label></td>
					<td><input type="number" min="0" value="0" id="CM" name="CM" /></td>
				</tr>
				<tr>
					<td><label for="TP">Nombre d'heures de travaux pratiques (TP) :</label></td>
					<td><input type="number" min="0" value="0" id="TP" name="TP" /></td>
				</tr>
				<tr>
					<td><label for="TD">Nombre d'heures de travaux dirigés (TD) :</label></td>
					<td><input type="number" min="0" value="0" id="TD" name="TD" /></td>
				</tr>
				<tr>
					<td><label for="CMTD">Nombre d'heures de mix cours magistraux / travaux dirigés (CMTD) :</label></td>
					<td><input type="number" min="0" value="0" id="CMTD" name="CMTD" /></td>
				</tr>
				<tr>
					<td><label for="Grp">Nombre de groupes :</label></td>
					<td><input type="number" min="1" value="1" id="Grp" name="Grp" required /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Ajouter un enseignement" /></td>
				</tr>
			</table>
	
		</form>

	</body>
	
</html>