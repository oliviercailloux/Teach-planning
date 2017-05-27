package io.github.oliviercailloux.teach_planning.teacher.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import io.github.oliviercailloux.teach_planning.model.Choice;
import io.github.oliviercailloux.teach_planning.model.Preference;
import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.service.PreferenceService;

@WebServlet(name="PreferenceServlet", urlPatterns={"/addPref"})
public class PreferenceServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	@Inject
	public PreferenceService ps;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		Teacher teacher = em.find(Teacher.class, Integer.parseInt(req.getParameter("teacher")));
		Teaching teaching = em.find(Teaching.class,Integer.parseInt(req.getParameter("teaching")));
		int hour = Integer.parseInt(req.getParameter("hour"));
		Choice choice;
		switch(req.getParameter("choice")){
		case "A":
			choice = Choice.A;
			break;
		case "B":
			choice = Choice.B;
			break;
		case "C":
			choice = Choice.C;
			break;
		default:
			choice = null;
			break;
		}
		try{
			ps.persist(new Preference(teacher, teaching, choice, hour));
			// Redirects to success page
			resp.sendRedirect("xhtml/preference/preferenceConfirmation.xhtml");
		}catch(EntityExistsException e){
			e.printStackTrace();
			// Redirects to failure page
			resp.sendRedirect("xhtml/preference/preferenceFailure.xhtml");
		}
	}
	
}