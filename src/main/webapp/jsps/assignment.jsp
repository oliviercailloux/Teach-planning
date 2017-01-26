<!DOCTYPE html>
<html>

	<head>
	<%@ page import="teach_planning.teacher.Teacher" %>
	<%@ page import="teach_planning.teacher.TeacherServlet" %>
	<%@ page import="teach_planning.teaching.Teaching" %>
	<%@ page import="teach_planning.teaching.TeachingServlet" %>
		<meta charset="UTF-8">
		<title>Teach Planning app - Assign teacher to course</title>
</head>
<body>
		<h1>Teach Planning app</h1>
		
		
			<h2>Affectation des enseignants aux matiéres : </h2>
			
			<form method="POST" name="assignmentnForm" action="../assignment">
				<table>
					<tr>
						<td><label for="teacherName">Enseignant : <span style="color:red">*</span></label></td>
						<td>
							<select name="teacher" id="teacher">
							<% for(Teacher teacher: TeacherServlet.teacherList) {%>
								<option value = "<%out.print(teacher.getLastname() +" "+teacher.getFirstname());%>"><%out.print(teacher.getLastname() +" "+teacher.getFirstname());%></option>
								<%} %>
						</td>
					</tr>
							
					<tr>
						<td><label for="teachingName">Matière : <span style="color:red">*</span></label></td>
						<td>
							<select name="teachingName" id="teachingName">
							<% for(Teaching teaching: TeachingServlet.teachingList) {%>
								<option value = "<%out.print(teaching.getName());%>"><%out.print(teaching.getName());%></option>
								<%} %>
						</td>
					</tr>
					
					<tr>
						<td><label for="teachingType">Type enseignement : <span style="color:red">*</span></label></td>
						<td>
							<select name="teachingType" id="teachingType">
								<option value = "CM">CM</option>
								<option value = "TD">TD</option> 
								<option value = "TP">TP</option> 
								<option value = "CMTD">CMTD</option> 
							</select>
						<!--  <input type="text" id="teachingType" name="teachingType" required /></td>-->
					</tr>
					
					<tr>
						<td><label for="className">Promotion : <span style="color:red">*</span></label></td>
						<td><input type="text" id="className" name="className" required /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><input type="submit" value="Affecter" /></td>
						<td><input type="button" value="Resumé affectation" onclick="redirect()"/></td>
					</tr>
				</table>
			</form>
			<script type="text/javascript">
				function redirect() {
					location.href="summaryAssignment.jsp";
				}
			</script>
</body>
</html>