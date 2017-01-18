package teach_planning.teaching;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="ResearchTeachingServlet", urlPatterns={"/searchTeaching"})
public class ResearchTeachingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		//resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		ResearchTeaching searchteaching = new ResearchTeaching(resp);
		String teaching = req.getParameter("Name");
		if(teaching!=null){
			searchteaching.search(teaching);
		}
	}
}
