package teachingPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@WebServlet("/addNewTeaching")
public class TeachingServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//this.getServletContext().getRequestDispatcher("/WebContent/addTeaching.jsps").forward(req, resp);
		PrintWriter pw=resp.getWriter();
		pw.println("TEST " + req.getParameter("teachingName"));
	}
	*/
	
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
		
		//doGet(req, resp);
		 
		PrintWriter pw=resp.getWriter();
		pw.println("Nouvelle matière ajoutée " + newTeaching.getName());
	}
	
}
