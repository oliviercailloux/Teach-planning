package teach_planning.teaching;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ResearchTeachingServlet", urlPatterns={"/listandsearch"})
public class ListAndResearchServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//  TODO Auto-generated method stub
			//super.doGet(req, resp);
			
			resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
			//resp.setContentType(MediaType.TEXT_HTML);
			resp.setLocale(Locale.FRENCH);
			
			ResearchTeaching searchteaching = new ResearchTeaching(resp);
			searchteaching.afficheform();

		
	}

}
