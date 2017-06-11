package io.github.oliviercailloux.teach_planning.teaching.bean;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import io.github.oliviercailloux.teach_planning.model.Assignment;
import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.service.AssignmentService;
import io.github.oliviercailloux.teach_planning.service.TeacherService;
import io.github.oliviercailloux.teach_planning.service.TeachingService;

@ManagedBean
@RequestScoped
public class AssignmentBean  implements Serializable {

	@PersistenceContext
	private EntityManager em;
	@Inject
	private AssignmentService aS;
	@Inject
	private TeacherService tS;
	@Inject
	private TeachingService tgS;
	
	private List<Object[]> assignments;
	private List<Teacher> teachers;
	private List<Teaching> teachings;
	
	private String teacherId;
	private String teachingId;

    @PostConstruct
    public void init() {
    	assignments = aS.getAllAssignment();
		teachers = tS.getAll();
		teachings = tgS.getAll();
	}

	public List<Object[]> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Object[]> assignments) {
		this.assignments = assignments;
	}
    
    public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Teaching> getTeachings() {
		return teachings;
	}

	public void setTeachings(List<Teaching> teachings) {
		this.teachings = teachings;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeachingId() {
		return teachingId;
	}

	public void setTeachingId(String teachingId) {
		this.teachingId = teachingId;
	}

	public String addAssignment(){
		// Setting Assignment parameters
		Teacher teacher = em.find(Teacher.class, Integer.parseInt(teacherId));
		Teaching teaching = em.find(Teaching.class,Integer.parseInt(teachingId));
			
		aS.persist(new Assignment(teacher,teaching));
		
		// Redirects to summary page of assignments
		return "summaryAssignment.xhtml?faces-redirect=true";
	}
}
