package teachingPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@WebServlet(name="TeachingServlet", urlPatterns={"/addNewTeaching"})
public class TeachingServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Teaching> teachingList = new ArrayList<Teaching>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//this.getServletContext().getRequestDispatcher("/webapp/jsps/addTeaching.jsp").forward(req, resp);
		//req.setAttribute("teachingName", "CM");
		//req.getRequestDispatcher("listTeaching.jsp").forward(req, resp);
		PrintWriter pw=resp.getWriter();
		pw.println("<a href=\"jsps/addTeaching.jsp\">Ajouter une nouvelle matière</a><br/>");
	}
	
	
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
		
		// Creating a new teaching and stocking it on the list
		Teaching newTeaching = new Teaching(teachingName, cm, td, tp, cmtd, grp);
		teachingList.add(newTeaching);
		 
		PrintWriter pw=resp.getWriter();
		
		// Recapitulation of the new teaching added
		pw.println("<h2>Nouvelle matière ajoutée !</h2>");
		pw.println(newTeaching.toString() + "<br/>");
		
		// Proposition to add new teaching
		pw.println("<a href=\"jsps/addTeaching.jsp\">Ajouter une nouvelle matière</a><br/>");
		//pw.println("<a href=\"jsps/listTeaching.jsp\">Liste des matières</a><br/>");
		
		// Recapitulation of all teaching stocked on the teaching list
		pw.println("<h1>Liste des matières</h1>");
		for(Teaching t : teachingList) {
			pw.println(t.toString() + "<br/>");
		}	
	}
	
}
