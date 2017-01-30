package teach_planning.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.logging.Logger;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		try(PrintWriter pw=resp.getWriter()) {
			if(session.getAttribute("typeSession").equals("admin")){
				int nbHours = Integer.parseInt(req.getParameter("nbHours"));
				String firstName = req.getParameter("teacherFirstname");
				String lastName = req.getParameter("teacherLastname");
			pw.println("Votre déclaration a bien été prise en compte : </br>"+firstName+" "+lastName+" souhaite enseigner "+nbHours+" cette année. </br>");
			}else if(session.getAttribute("typeSession").equals("teacher")){
				int nbHours = Integer.parseInt(req.getParameter("nbHours"));		
				pw.println(" Votre déclaration a bien été prise en compte :  vous souhaitez enseigner "+nbHours+" cette année.</br>");
			}
			pw.println("<a href=\"index.jsp\"> Retour à l'accueil </a>");
		} catch(Exception e) {
			Logger logger = Logger.getLogger(getClass().getName());
			logger.severe("Impossible to get writer from response in TeacherHoursServlet \n "
					+ "The error is : " + e);
		}
	}

}
