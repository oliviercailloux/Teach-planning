package teach_planning.teaching;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import teach_planning.teacher.Teacher;
import teach_planning.teacher.TeacherServlet;

@WebServlet(name="AssignmentServlet", urlPatterns={"/assignment"})
public class AssignmentServlet extends HttpServlet {

	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	// public static because no DB
	public static ArrayList<Assignment> listAssignation = new ArrayList<Assignment>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Redirects to the assignment jsp page if servlet is directly called on URL
		resp.sendRedirect("jsps/assignment.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		// Setting Assignment parameters
		Teacher teacher = TeacherServlet.teacherList.get(Integer.parseInt(req.getParameter("teacher")));
		Teaching teaching = TeachingServlet.teachingList.get(Integer.parseInt(req.getParameter("teaching")));
		String teachingType = req.getParameter("teachingType");
		String promotion = req.getParameter("className");
		
		// Creating Assignment
		Assignment assignment = new Assignment(teacher, teaching, teachingType, promotion);
		
		// Adding assignment into the list
		listAssignation.add(assignment);
		
		// Redirects to summary page of assignments
		resp.sendRedirect("jsps/summaryAssignment.jsp");
	}
	
}