package servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class ShowChargeTeacherServlet
 */
public class ShowChargeTeacherServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType(MediaType.TEXT_HTML);
		response.setLocale(Locale.FRENCH);

		Print print = new Print(response);
		
		String teacher = request.getParameter("teacher");
		
		Logger logger = Logger.getLogger(getClass().getName());
		
		if(teacher != null){
			print.printCharge(teacher);
		}else{
			print.printErrorRecup(teacher);
			logger.severe("L'enseignant n'est pas renseign� : "+teacher);
		}
	}
}
