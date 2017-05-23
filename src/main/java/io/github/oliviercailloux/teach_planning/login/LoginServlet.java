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
	
	private ServletOutputStream out;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		out = resp.getOutputStream();
		out.println("test");
		if(req.getAttributeNames() != null)
			out.println(req.getAttributeNames().toString());
		else
			out.println("null");
		
		out.println("1");
		
		Enumeration<String> attributesNames = req.getAttributeNames();
		while(attributesNames.hasMoreElements()) {
		  String headerName = attributesNames.nextElement();
		  out.println("Attribute Name - " + headerName + ", Value - " + req.getHeader(headerName));
		}
		
		out.println("2");
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
		  String headerName = headerNames.nextElement();
		  out.println("Header Name - " + headerName + ", Value - " + req.getHeader(headerName));
		}
		
	
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
			String typeAccount = isExistAccount(login, password);
			
			switch (typeAccount) {
				case "NOT_EXIST":
					session.setAttribute("errorLogin", "Le login '" + login + "' n'existe pas !");
					break;
				case "NOT_PASS":
					session.setAttribute("errorLogin", "Votre mot de passe est incorrect !");
					session.setAttribute("loginRemember", login);
					break;
				case "ADMINISTRATOR":
					session.setAttribute("typeSession", "admin");
					break;
				case "TEACHER":
					session.setAttribute("typeSession", "teacher");
					break;
				default:
					session.setAttribute("errorLogin", "UNKNOWN ERROR");
					break;
			}
			
		}
		
		resp.sendRedirect("jsps/login.jsp");
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