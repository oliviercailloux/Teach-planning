package issue1;

import java.io.IOException;
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

@WebServlet("/showChargeTeacher")
public class ShowChargeTeacherServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		final ServletOutputStream out = resp.getOutputStream();
		
		String teacher = req.getParameter("teacher");
		
		out.println("<h1> Charge totale de l'enseignant : "+teacher+"</h1>");
		
		Logger logger = Logger.getLogger(getClass().getName());
		
		try {
			out.println(
					"<html>"
					+ "<body>"
					+ "	<p> Récupéré les charges du prof.</p>"
					+ "</body>"
					+"</html>");
		} catch(NumberFormatException e) {
			out.println("<"
					+ "html>"
					+ "	<body>"
					+ "		<p>L'enseignant renseigné n'est pa : teacher = " + teacher + "</p>"
					+ "	</body>"
					+ "</html>");
			logger.severe("L'enseignant renseigné n'est pa : teacher = " + teacher);
		}
	}
}
