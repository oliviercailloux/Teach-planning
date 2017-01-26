package teach_planning.teaching;

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

@WebServlet(name="AssignmentServlet", urlPatterns={"/assignment"})
public class AssignmentServlet extends HttpServlet {

	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Assignment> listAssignation = new ArrayList<Assignment>();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// Setting Assignment parameters
		Assignment assignment = new Assignment();
		assignment.setNomEnseignant(req.getParameter("teacher"));
		assignment.setMatière(req.getParameter("teachingName"));
		assignment.setTypeEnseignement(req.getParameter("teachingType"));
		assignment.setPromotion(req.getParameter("className"));
				
		listAssignation.add(assignment);
		
		PrintWriter pw=resp.getWriter();
		pw.println("<a href=\"jsps/assignment.jsp\">Faire une nouvelle affectation</a><br/>");		
		pw.println("<a href=\"jsps/summaryAssignment.jsp\">Recapitulatif des affectation</a><br/>");	
		
	}
	

}