package io.github.oliviercailloux.teach_planning.teacher.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;

@WebServlet(name="PreferenceServlet", urlPatterns={"/addPref"})
public class PreferenceServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
private ServletOutputStream out;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		Teacher teacher = new Teacher("Toto", "Titi", "Tata");
		
		String teaching = "M";
		String choice = "choix";
		String hour = "H";
		
		for(int i = 1; i<39; i++){
			choice= choice+i;
			
			if(!req.getParameter(choice).equals("choix0")){
				teaching = teaching+i;
				hour = hour+i;
				int h = Integer.parseInt(req.getParameter(hour));
				
				Teaching t = new Teaching(req.getParameter(teaching), h);
				teacher.addPreference(req.getParameter(choice), t);
			}
			choice = "choix";
			hour = "H";
			teaching = "M";
		}
		try(PrintWriter pw=resp.getWriter()) {
			teacher.printPreferences(pw);
		} catch(Exception e) {
			out = resp.getOutputStream();
			out.println("ERROR :"  + e);
			Logger logger = Logger.getLogger(getClass().getName());
			logger.severe("Impossible to get writer from response in PreferenceServlet \n "
					+ "The error is : " + e);
		}
	}
	
}