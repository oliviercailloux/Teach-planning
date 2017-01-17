package loginPackage;

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
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import loginPackage.Login;

@WebServlet(name="LoginServlet", urlPatterns={"/connect", "/disconnect"})
public class LoginServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	// public because no DB
	// static to be called on teacher because no db ...
	public static ArrayList<Login> loginList = new ArrayList<Login>();
	
	private ArrayList<Login> loginAdmin = new ArrayList<Login>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.jsp");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// vider à chaque fois qu'on rappel le post
		loginAdmin = new ArrayList<Login>();
		loginAdmin.add(new Login("cathy.marques@test.com", "root"));
		loginAdmin.add(new Login("mathilde.masson@test.com", "root"));
		
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		// Getting form parameters
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String logout = req.getParameter("logout");
		 
		PrintWriter pw=resp.getWriter();
		HttpSession session = req.getSession();
		
		if(logout != null) {
			 session.setAttribute("typeSession", null);
			 resp.sendRedirect("jsps/login.jsp");
		} else {
		
		if(isExistTeacherAccount(login, password)) {
			// Si teacher
			pw.println("<h2>Vous êtes connecté !</h2>");
			pw.println("<a href=\"index.jsp\">Rendez-vous à l'index!</a><br/>");
	        session.setAttribute("typeSession", "teacher");
		} else if(isExistAdminAccount(login, password)) {
			// Si admin
			pw.println("<h2>Vous êtes connecté en tant qu'administrateur!</h2>");
			pw.println("<a href=\"jsps/addTeacher.jsp\">Ajouter un nouvel enseignant</a><br/>");
			pw.println("<a href=\"jsps/addTeaching.jsp\">Ajouter un nouvel enseignement</a><br/>");
	        session.setAttribute("typeSession", "admin");
		} else {
			// Si non redirection sur la page de connection
			session.setAttribute("errorLogin", "Ce login n'existe pas ou votre mot de passe est incorrect !");
			resp.sendRedirect("jsps/login.jsp");
		}
		}
	}
	
	private boolean isExistAdminAccount(String login, String password) {
		for(Login l : loginAdmin) {
			if(l.getLogin().equals(login)) {
				if(l.getPassword().equals(password)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}


	private boolean isExistTeacherAccount(String login, String password) {
		for(Login l : loginList) {
			if(l.getLogin().equals(login)) {
				if(l.getPassword().equals(password)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
	
}
