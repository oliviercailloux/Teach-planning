package io.github.oliviercailloux.teach_planning.teacher.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import io.github.oliviercailloux.teach_planning.model.Assignment;
import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.service.TeacherService;

@WebServlet(name="ShowChargeTeacherServlet", urlPatterns={"/chargeTeacher"})
public class ShowChargeTeacherServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;
	private ServletOutputStream out;

	@PersistenceContext
	private EntityManager em;

	@Inject
	private TeacherService teacherS;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType(MediaType.TEXT_HTML);
		response.setLocale(Locale.FRENCH);
		out = response.getOutputStream();
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			Teacher teacher = em.find(Teacher.class, id) ;
			if (teacher != null) {
				printCharge(teacher);
			} else {
				printErrorNotFound(); 
			}
		}catch(NumberFormatException e){
			printErrorRecup();
			e.getMessage();
		}
	}
	
	private void printErrorNotFound() throws IOException {
		out.println(
				"<html>"
				+ "	<body>"
				+ "		<p>ERREUR : L'enseignant est inconnu. </p>"
				+ "		<p> Essayer la liste suivante </p>"
				+ "		<ul>");
		for(Teacher t : teacherS.getAll()){
			out.println("<li>"+t.getFirstname()+" "+t.getLastname()+"</li>");
		}
		out.println(
				"</ul>"
				+ "	</body>"
				+ "</html>");		
	}
	
	private void printCharge(Teacher teacher) throws IOException{
		String toDisplay = "<html>"
				+ "<head><style>"
				+ "table {"
				+ "border-collapse: collapse;"
				+ "}"
				+ "table, td, th {"
				+ "    border: 1px solid black;"
				+ "}"
				+ "#titre {"
				+ "background-color: #A0D3EF;"
				+ "}"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<h1> Charge totale de l'enseignant : "+teacher.getFirstname()+" "+teacher.getLastname().toUpperCase()+"</h1>"
				+ "<table>"
				+"<tr id='titre'><th>Nom matiere</th><th>Type</th><th>Diplome</th><th>Heures CM</th><th>Heures TD</th></tr>";

		StringBuilder sb = new StringBuilder(toDisplay);

		for(Assignment teaching : teacher.getTeachings()) {
			sb.append(teaching.getTeaching().detailTeaching());
		}
	
		sb.append("</table>");
		sb.append("<a href=\"index.jsp\"> Retour à l'accueil </a>");
		sb.append("</body>");
		sb.append("</html>");
		
		String finaltoDisplay = sb.toString();
		
		out.println(finaltoDisplay);	
	}
	
	private void printErrorRecup() throws IOException{
		out.println(
				"<html>"
				+ "	<body>"
				+ "<h1> Pour visualiser la charge d'un enseignant cliquer sur son lien :</h1>"
				+ "		<ul>");
		for(Teacher t : teacherS.getAll()){
			out.println("<li><a href =\"chargeTeacher?id="+t.getId()+"\">"+t.getFirstname()+" "+t.getLastname()+"</a></li>");
		}
		out.println(
				"</ul>"
				+ "		<a href=\"index.jsp\"> Retour à l'accueil </a>"
				+ "	</body>"
				+ "</html>");
	}
	
}
