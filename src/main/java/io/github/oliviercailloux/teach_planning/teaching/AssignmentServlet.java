package io.github.oliviercailloux.teach_planning.teaching;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.service.AssignmentService;

@WebServlet(name="AssignmentServlet", urlPatterns={"/assignment"})
public class AssignmentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	@Inject
	public AssignmentService as;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		// Setting Assignment parameters
		
		Teacher teacher = em.find(Teacher.class, Integer.parseInt(req.getParameter("teacher")));
		Teaching teaching = em.find(Teaching.class,Integer.parseInt(req.getParameter("teaching")));
			
		as.persist(teacher.addAssignment(teaching));
		
		// Redirects to summary page of assignments
		resp.sendRedirect("jsps/summaryAssignment.jsp");
	}
	
}