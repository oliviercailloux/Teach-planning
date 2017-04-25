<!DOCTYPE html>
<html>

	<head>
		<%@ page import="teach_planning.teacher.TeacherServlet"%>
		<%@ page import="teach_planning.teaching.Teaching"%>
		<%@ page import="teach_planning.teaching.TeachingServlet"%>
		
		<meta charset="UTF-8">
		<title>Teach Planning app - Assign teacher to a course</title>
		
		<script type="text/javascript">
			function redirect() {
				location.href = "summaryAssignment.jsp";
			}
		</script>
	</head>
	
	<body>
	
		<h1>Teach Planning app</h1>
		
		<%
			if(session.getAttribute("typeSession") != null && session.getAttribute("typeSession").equals("admin")) {
		%>

			<h2>Affectation des enseignants aux mati�res :</h2>
	
			<form method="POST" name="assignmentnForm" action="../assignment">
				<table>
					<tr>
						<td>
							<label for="teacher">Enseignant : <span style="color: red">*</span></label>
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td>
							<label for="teaching">Mati�re : <span style="color: red">*</span></label>
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td>
							<label for="teachingType">Type enseignement : <span style="color: red">*</span></label>
						</td>
						<td>
							<select name="teachingType" id="teachingType" required>
								<option value="CM">CM</option>
								<option value="TD">TD</option>
								<option value="TP">TP</option>
								<option value="CMTD">CMTD</option>
							</select>
					</tr>
					<tr>
						<td>
							<label for="className">Promotion : <span style="color: red">*</span></label>
						</td>
						<td>
							<input type="text" id="className" name="className" required />
						</td>
					</tr>
		
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Affecter" />
						</td>
					</tr>		
				</table>
			</form>	
			
			<form method="POST" name="logoutForm" action="../disconnect" style="position:absolute;top:0px;right:0px;">
				<input type="hidden" id="logout" name="logout" value="logout" />
				<input type="submit" value="Se d�connecter" />
			</form>
			
		<%
			} else if(session.getAttribute("typeSession") != null && session.getAttribute("typeSession").equals("teacher")) {
		%>
			<h2>En tant que professeur vous n'�tes pas autoris� � acc�der � cette page !</h2>
			
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