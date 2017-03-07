package teach_planning.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import teach_planning.model.LoginModel;
import teach_planning.model.TeacherModel;
import teach_planning.model.TeachingModel;
import teach_planning.model.TypeAccount;
import teach_planning.service.LoginService;
import teach_planning.service.TeacherService;
import teach_planning.service.TeachingService;

@WebServlet(name="LoginServlet", urlPatterns={"/connect", "/disconnect"})
public class LoginServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	// public static because no DB
	public static List<Login> loginList = new ArrayList<>();
	
	// public static because no DB
	public static List<Login> loginAdmin = new ArrayList<>();
	
	@Inject
	public LoginService ls;
	
	@Inject
	public TeacherService ts;
	
	@Inject
	public TeachingService tgs;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ls.persist(new LoginModel("hello", "hello", TypeAccount.ADMINISTRATOR));
		
		ts.persist(new TeacherModel("teach", "teach", "teach@t.com"));
		
		tgs.persist(new TeachingModel("espagnol", 20, 10, 15, 0, 2));
		
		resp.setContentType("text/html");
	    @SuppressWarnings("resource")
		PrintWriter out = resp.getWriter();
	    
	    out.println("debut");
	   /* for(String s : ls.getAllLogins()) {
	    	out.println(s);
	    }*/
	    for(LoginModel lm : ls.getAll()) {
	    	out.println(lm.getLogin());
	    	out.println(lm.getPassword());
	    	out.println(lm.getTypeAccount());
	    }
	    out.println("fin");
	    
	    out.println("debut");
	    for(TeacherModel tm : ts.getAll()) {
	    	out.println(tm.getFirstname());
	    	out.println(tm.getLastname());
	    	out.println(tm.getEmail());
	    }
	    out.println("fin");
	    
	    out.println("debut");
	    for(TeachingModel tgm : tgs.getAll()) {
	    	out.println(tgm.getName());
	    	out.println(tgm.getNbCM());
	    	out.println(tgm.getNbCMTD());
	    	out.println(tgm.getNbGrp());
	    	out.println(tgm.getNbTD());
	    	out.println(tgm.getNbTP());
	    }
	    out.println("fin");
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