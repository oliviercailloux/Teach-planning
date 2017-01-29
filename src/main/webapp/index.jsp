<html>
	<body>
		<h2>
			<span style='color: blue'>Welcome on the teach planning App !</span>
		</h2>
		<br>
		<form method="GET" name="listandsearch" action="listandsearch">
			<table>
				<tr>
					<td><input type="submit" value="Search Information about a teaching" /></td>
				</tr>
			</table>
		</form>
		
		<form method="GET" name="listandsearch" action="chargeTeacher">
			<table>
				<tr>
					<td><input type="submit" value="Search Information about a teacher" /></td>
				</tr>
			</table>
		</form>
		
		<form method="GET" name="listandsearch" action="jsps/addTeaching.jsp">
			<table>
				<tr>
					<td><input type="submit" value="Add a new teaching" /></td>
				</tr>
			</table>
		</form>

		<form method="GET" name="genServiceFile" action="jsps/EmptyServiceFile.jsp">
			<table>
				<tr>
					<td><input type="submit" value="Generate empty service file" /></td>
				</tr>
			</table>
		</form>
		
		<a href="jsps/prefView/prefForm.jsp">Add preference for teacher</a>
	
	</body>
</html>
