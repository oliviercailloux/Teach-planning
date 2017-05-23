package teach_planning.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import teach_planning.model.Login;
import teach_planning.model.Teacher;
import teach_planning.service.LoginService;
import teach_planning.service.TeacherService;

@WebServlet(name="TeacherServlet", urlPatterns={"/addNewTeacher"})
public class TeacherServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	private ServletOutputStream out;
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	public LoginService ls;

	@Inject
	private TeacherService teacherS;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		// Getting form parameters
		String teacherFirstname = req.getParameter("teacherFirstname");
		String teacherLastname = req.getParameter("teacherLastname");
		String teacherEmail = req.getParameter("teacherEmail");
		
		Teacher newTeacher = new Teacher();
		newTeacher.setFirstname(teacherFirstname);
		newTeacher.setLastname(teacherLastname);
		newTeacher.setEmail(teacherEmail);
		teacherS.persist(newTeacher);
		
		// Creating an account for the new teacher and stocking it on the list
		Login newLogin = new Login(teacherEmail, "default");
		ls.persist(newLogin);
		 
		try(PrintWriter pw=resp.getWriter()) {
			// Recapitulation of the new teacher added
			pw.println("<h2>Nouvel enseignant ajouté !</h2>");
			pw.println(newTeacher.toString() + "<br/><br/>");
			
			// Proposition to add new teacher
			pw.println("<a href=\"jsps/addTeacher.jsp\">Ajouter un nouvel enseignant</a><br/>");
			pw.println("<a href=\"index.jsp\"> Retour à l'accueil </a>");
			
			// Recapitulation of all teachers stocked on the teaching list
			pw.println("<h1>Liste des enseignants</h1>");
			for(Teacher t : teacherS.getAll()) {
				pw.println(t.toString() + "<br/>");
			}	
		} catch(Exception e) {
			out.println("ERROR : " + e);
			Logger logger = Logger.getLogger(getClass().getName());
			logger.severe("Impossible to get writer from response in TeacherServlet \n "
					+ "The error is : " + e);
		}
	}
	
}