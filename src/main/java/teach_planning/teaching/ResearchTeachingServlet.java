package teach_planning.teaching;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

@WebServlet(name="ResearchTeachingServlet", urlPatterns={"/searchTeaching"})
public class ResearchTeachingServlet extends HttpServlet {

	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		HttpSession session = req.getSession();
		
		//Giving to the session the index of the teaching researched 
		//if not null (if servlet called directly)
		//if not empty (no number passed)
		//if index exists on list
		if(req.getParameter("teaching") != null && req.getParameter("teaching")!= "") {
			int index = Integer.parseInt(req.getParameter("teaching"));
			if(index < TeachingServlet.teachingList.size()) {
				session.setAttribute("indexTeaching", index);
			}
		}
		
		//Come back to page
		resp.sendRedirect("jsps/researchTeaching.jsp");
	}
}
