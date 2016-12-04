package servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
     * @see HttpServlet#HttpServlet()
     */
    public ShowChargeTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType(MediaType.TEXT_HTML);
		response.setLocale(Locale.FRENCH);
		
		final ServletOutputStream out = response.getOutputStream();
		
		java.lang.String teacher = request.getParameter("teacher");
		
		out.println("<h1> Charge totale de l'enseignant : "+teacher+"</h1>");
		
		Logger logger = Logger.getLogger(getClass().getName());
		
		try {
			out.println(
					"<html>"
					+ "<body>"
					+ "	<p> Récupérer les charges du prof.</p>"
					+ "</body>"
					+"</html>");
		} catch(IOException e) {
			out.println("<"
					+ "html>"
					+ "	<body>"
					+ "		<p>L'enseignant renseigné n'est pas renseigné : teacher = " + teacher + "</p>"
					+ "	</body>"
					+ "</html>");
			logger.severe("L'enseignant renseigné n'est pas renseigné : teacher = " + teacher);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
