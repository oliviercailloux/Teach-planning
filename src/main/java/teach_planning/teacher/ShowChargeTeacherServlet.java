package teach_planning.teacher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class ShowChargeTeacherServlet
 */

@WebServlet(name="ShowChargeTeacherServlet", urlPatterns={"/chargeTeacher"})
public class ShowChargeTeacherServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType(MediaType.TEXT_HTML);
		response.setLocale(Locale.FRENCH);

		Print print = new Print(response);
		
		String teacherName = request.getParameter("nom");
		String teacherSurname = request.getParameter("prenom");

		if (teacherName != null && teacherSurname != null) {
			if (print.findTeacher(teacherSurname, teacherName) != -1) {
				print.printCharge(teacherName, print.findTeacher(teacherSurname, teacherName));
			} else {
				print.printErrorNotFound(teacherName); 
			}
		}  else {
			print.printErrorRecup();
		}

	}
}
