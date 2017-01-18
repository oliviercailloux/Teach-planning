package teacherPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import loginPackage.Login;
import loginPackage.LoginServlet;

@WebServlet(name="TeacherServlet", urlPatterns={"/addNewTeacher"})
public class TeacherServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	// public because no DB
	public ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("jsps/addTeacher.jsp");
	}
	
	
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
		
		// Creating a new teacher and stocking it on the list
		Teacher newTeacher = new Teacher(teacherFirstname,teacherLastname,teacherEmail);
		teacherList.add(newTeacher);
		
		// Creating an account for the new teacher and stocking it on the list
		Login newLogin = new Login(teacherEmail, "default");
		LoginServlet.loginList.add(newLogin);
		 
		PrintWriter pw=resp.getWriter();
		
		// Recapitulation of the new teacher added
		pw.println("<h2>Nouvel enseignant ajout� !</h2>");
		pw.println(newTeacher.toString() + "<br/><br/>");
		
		// Proposition to add new teacher
		pw.println("<a href=\"jsps/addTeacher.jsp\">Ajouter un nouvel enseignant</a><br/>");
		pw.println("<a href=\"index.jsp\"> Retour � l'accueil </a>");
		
		// Recapitulation of all teachers stocked on the teaching list
		pw.println("<h1>Liste des enseignants</h1>");
		for(Teacher t : teacherList) {
			pw.println(t.toString() + "<br/>");
		}	
	}
	
}
