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
import javax.ws.rs.core.MediaType;

import loginPackage.Login;

@WebServlet(name="LoginServlet", urlPatterns={"/connect"})
public class LoginServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	// public because no DB
	// static to be called on teacher because no db ...
	public static ArrayList<Login> loginList = new ArrayList<Login>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		
		// TO MODIFIY
		pw.println("<a href=\"jsps/addTeacher.jsp\">Ajouter un nouvel enseignant</a><br/>");
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
		 
		PrintWriter pw=resp.getWriter();
		
		if(isExistAccount(login, password)) {
			// Si connexion OK
			pw.println("<h2>Vous êtes connecté !</h2>");
		} else {
			// Si non redirection sur la page de connection
			resp.sendRedirect("jsps/login.jsp");
		}
	}
	
	private boolean isExistAccount(String login, String password) {
		return true;
	}
	
}
