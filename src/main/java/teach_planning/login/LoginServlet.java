package teach_planning.login;

import java.io.IOException;
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

@WebServlet(name="LoginServlet", urlPatterns={"/connect", "/disconnect"})
public class LoginServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	// public because no DB
	// static to be called on teacher because no db ...
	public static ArrayList<Login> loginList = new ArrayList<Login>();
	
	// public static because no DB
	@administrator
	public static ArrayList<Login> loginAdmin = new ArrayList<Login>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.jsp");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		// Getting form parameters
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String logout = req.getParameter("logout");
		 
		HttpSession session = req.getSession();
		
		if(logout != null) {
			 session.setAttribute("typeSession", null);
		} else {
		
			if(isExistTeacherAccount(login, password)) {
				// If teacher
		        session.setAttribute("typeSession", "teacher");
			} else if(isExistAdminAccount(login, password)) {
				// If admin
		        session.setAttribute("typeSession", "admin");
			} else {
				// If not exists
				session.setAttribute("errorLogin", "Ce login n'existe pas ou votre mot de passe est incorrect !");
			}
		}
		
		resp.sendRedirect("jsps/login.jsp");
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
