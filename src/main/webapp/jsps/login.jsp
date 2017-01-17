<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Teach Planning app - Log In</title>
	</head>
	
	<body>
		
		<h1>Teach Planning app</h1>
		
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

	</body>
	
</html>