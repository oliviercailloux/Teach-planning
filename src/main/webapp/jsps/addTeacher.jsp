<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Teach Planning app - Add a teacher</title>
	</head>
	
	<body>
		
		<h1>Teach Planning app</h1>
		
		<h2>Ajouter un nouvel enseignant</h2>
		
		<i>NB : L'email de l'enseignant lui servira de login.
		De plus, le mot de passe est "default". Il devra �tre modifi� � la 1�re connexion.</i>
		
		<form method="POST" name="addTeacherForm" action="../addNewTeacher">

			<table>
				<tr>
					<td><label for="teacherFirstname">Pr�nom :<span style="color:red">*</span></label></td>
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

	</body>
	
</html>