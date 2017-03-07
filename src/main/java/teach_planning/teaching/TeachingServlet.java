package teach_planning.teaching;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import teach_planning.model.TeachingModel;
import teach_planning.service.TeachingService;

@WebServlet(name="TeachingServlet", urlPatterns={"/addNewTeaching"})
public class TeachingServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	@Inject
	private TeachingService teachingS;



	
	// public because no DB
	public static List<TeachingModel> teachingList = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		// Getting form parameters
		// NB : the parseInt not throwing exception because number format already checked on form
		String teachingName = req.getParameter("teachingName");
		int cm = Integer.parseInt(req.getParameter("CM"));
		int tp = Integer.parseInt(req.getParameter("TP"));
		int td = Integer.parseInt(req.getParameter("TD"));
		int cmtd = Integer.parseInt(req.getParameter("CMTD"));
		int grp = Integer.parseInt(req.getParameter("Grp"));
		
		TeachingModel newTeaching = new TeachingModel(teachingName, cm, td, tp, cmtd, grp);

		//teachingList.add(newTeaching);

		teachingS.persist(newTeaching);

		teachingList = teachingS.getAll();

		 
		try(PrintWriter pw=resp.getWriter()) {
		
			// Recapitulation of the new teaching added
			pw.println("<h2>Nouvel enseignement ajouté !</h2>");
			pw.println(newTeaching.toString() + "<br/>");
			
			// Proposition to add new teaching
			pw.println("<a href=\"jsps/addTeaching.jsp\">Ajouter un nouvel enseignement</a><br/>");
			pw.println("<a href=\"index.jsp\"> Retour à l'accueil </a>");
			
			// Recapitulation of all teaching stocked on the teaching list
			pw.println("<h1>Liste des enseignements</h1>");
			for(TeachingModel t : teachingList) {
				pw.println(t.toString() + "<br/>");
			}	
		} catch(Exception e) {
			Logger logger = Logger.getLogger(getClass().getName());
			logger.severe("Impossible to get writer from response in TeachingServlet \n "
					+ "The error is : " + e);
		}
	}
	
}
