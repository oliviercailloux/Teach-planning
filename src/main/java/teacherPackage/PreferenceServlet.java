package teacherPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import teachingPackage.*;

@WebServlet(name="PreferenceServlet", urlPatterns={"/addPref"})
public class PreferenceServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	@Inject
	private TeacherInterface teacher;
	//private ArrayList<Teaching> teachingList = new ArrayList<Teaching>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		PrintWriter pw=resp.getWriter();
		
		pw.println("<a href=\"prefView/prefForm.jsp\">Ajouter une préference</a><br/>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		String choix = req.getParameter("RaN");
		Teaching teaching = new Teaching("RaN", "CM", "M1 INFO", 18.0, 27.0);
		teacher.addPreference(choix, teaching);
		
		PrintWriter pw=resp.getWriter();
		
		teacher.printPreferences(pw);
	}
}
