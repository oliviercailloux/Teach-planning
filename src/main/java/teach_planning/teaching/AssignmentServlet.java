package teach_planning.teaching;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import teach_planning.model.Teacher;
import teach_planning.model.Teaching;
import teach_planning.service.TeacherService;
import teach_planning.service.TeachingService;

@WebServlet(name="AssignmentServlet", urlPatterns={"/assignment"})
public class AssignmentServlet extends HttpServlet {

	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	public static List<Assignment> listAssignation = new ArrayList<>();

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private TeacherService teacherS;
	
	@Inject
	private TeachingService teachingS;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		// Setting Assignment parameters
		Teacher teacher = teacherS.getAll().get(Integer.parseInt(req.getParameter("teacher")));
		Teaching teaching = teachingS.getAll().get(Integer.parseInt(req.getParameter("teaching")));
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