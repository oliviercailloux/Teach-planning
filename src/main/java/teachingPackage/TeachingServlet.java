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
	
	
	//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//this.getServletContext().getRequestDispatcher("/webapp/jsps/addTeaching.jsp").forward(req, resp);
		//PrintWriter pw=resp.getWriter();
		//pw.println("HELLO I M HERE");
	//}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		String teachingName = req.getParameter("teachingName");
		int cm = Integer.parseInt(req.getParameter("CM"));
		int tp = Integer.parseInt(req.getParameter("TP"));
		int td = Integer.parseInt(req.getParameter("TD"));
		int cmtd = Integer.parseInt(req.getParameter("CMTD"));
		int grp = Integer.parseInt(req.getParameter("Grp"));
		
		Teaching newTeaching = new Teaching(teachingName, cm, td, tp, cmtd, grp);
		teachingList.add(newTeaching);
		 
		PrintWriter pw=resp.getWriter();
		/*pw.println("Nouvelle matière ajoutée " + newTeaching.getName() + "<br/>");
		pw.println("Nb cours magistraux " + newTeaching.getNbCM() + "<br/>");
		pw.println("Nb cours tp " + newTeaching.getNbTP() + "<br/>");
		pw.println("Nb cours td " + newTeaching.getNbTD() + "<br/>");
		pw.println("Nb cours cmtd " + newTeaching.getNbCMTD() + "<br/>");
		pw.println("Nb groupes " + newTeaching.getNbGrp());*/
		
		//pw.println(teachingList.toString());
		
		//doGet(req, resp);
		
		pw.println("<h2>Nouvelle matière ajoutée !</h2> <br/>");
		pw.println(newTeaching.toString() + "<br/>");
		pw.println("<a href=\"jsps/addTeaching.jsp\">Ajouter une nouvelle matière</a><br/>");
		pw.println("<a href=\"jsps/listTeaching.jsp\">Liste des matières</a><br/>");
		
		pw.println("<h1>Liste des matières</h1><br/>");
		for(Teaching t : teachingList) {
			pw.println(t.toString() + "<br/>");
		}	
	}
	
}
