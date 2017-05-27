package io.github.oliviercailloux.teach_planning.login;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import io.github.oliviercailloux.teach_planning.model.Login;
import io.github.oliviercailloux.teach_planning.service.LoginService;
import io.github.oliviercailloux.teach_planning.service.TeacherService;
import io.github.oliviercailloux.teach_planning.service.TeachingService;

@WebServlet(name="LoginServlet", urlPatterns={"/connect", "/disconnect"})
public class LoginServlet extends HttpServlet {

	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	public LoginService ls;
	@Inject
	public TeacherService ts;
	@Inject
	public TeachingService tgs;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);

		// Getting form parameters
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String logout = req.getParameter("logout");
		
		HttpSession session = req.getSession();

		String typeAccount = isExistAccount(login, password);
		if(logout != null) {
			 session.setAttribute("typeSession", null);
			 resp.sendRedirect("index.jsp");
		}else{
			switch (typeAccount) {
			case "NOT_EXIST":
				resp.sendRedirect("xhtml/login/connectionFailure.xhtml");
				break;
			case "NOT_PASS":
				resp.sendRedirect("xhtml/login/connectionFailure.xhtml");
				break;
			case "ADMINISTRATOR":
				session.setAttribute("typeSession", "admin");
				resp.sendRedirect("index.jsp");
				break;
			case "TEACHER":
				session.setAttribute("typeSession", "teacher");
				resp.sendRedirect("index.jsp");
				break;
			default:
				resp.sendRedirect("xhtml/login/connectionFailure.xhtml");
				break;
			}
		}
	}

	private String isExistAccount(String login, String password) {
		for(Login lm : ls.getAll()) {
			if(lm.getLogin().equals(login)) {
				if(lm.getPassword().equals(password)) {
					return lm.getTypeAccount().toString();
				}
				return "NOT_PASS";
			}
		}
		return "NOT_EXIST";
	}

}