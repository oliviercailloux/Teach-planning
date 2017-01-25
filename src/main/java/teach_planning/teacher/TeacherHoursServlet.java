package teach_planning.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class TeacherHoursServlet
 */

@WebServlet(name="TeacherHoursServlet", urlPatterns={"/teacherHours"})
public class TeacherHoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		resp.sendRedirect("jsps/nbHours.jsp");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		if(session.getAttribute("typeSession").equals("admin")){
			int nbHours = Integer.parseInt(req.getParameter("nbHours"));
			String firstName = req.getParameter("teacherFirstname");
			String lastName = req.getParameter("teacherLastname");
		}else if(session.getAttribute("typeSession").equals("teacher")){
			int nbHours = Integer.parseInt(req.getParameter("nbHours"));
		}
	}

}
