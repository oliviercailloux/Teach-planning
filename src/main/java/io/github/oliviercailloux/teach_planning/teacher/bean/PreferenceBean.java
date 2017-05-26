package io.github.oliviercailloux.teach_planning.teacher.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.github.oliviercailloux.teach_planning.model.Choice;
import io.github.oliviercailloux.teach_planning.model.Preference;
import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.service.PreferenceService;
import io.github.oliviercailloux.teach_planning.service.TeacherService;
import io.github.oliviercailloux.teach_planning.service.TeachingService;

@ManagedBean
@RequestScoped
public class PreferenceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	private String teacher;
	private String teaching;
	private String choice;
	private String hour;
	
	private List<Teacher> teachers;
	private List<Teaching> teachings;

	@Inject
	private PreferenceService prefS;
	@Inject
	private TeacherService tS;
	@Inject
	private TeachingService tgS;

    @PostConstruct
    public void init() {
		teachers = tS.getAll();
		teachings = tgS.getAll();
	}
	
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTeaching() {
		return teaching;
	}

	public void setTeaching(String teaching) {
		this.teaching = teaching;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}
	
	public List<Teaching> getTeachings() {
		return teachings;
	}

	public String savePreference() {

		Teacher teacherInserted = em.find(Teacher.class, Integer.parseInt(teacher));
		Teaching teachingInserted = em.find(Teaching.class,Integer.parseInt(teaching));
		Choice choiceInserted;
		switch(choice){
		case "A":
			choiceInserted = Choice.A;
			break;
		case "B":
			choiceInserted = Choice.B;
			break;
		case "C":
			choiceInserted = Choice.C;
			break;
		default:
			choiceInserted = null;
			break;
		}

		int hourInserted = Integer.parseInt(hour);
		Preference addedPreference = new Preference(teacherInserted, teachingInserted, choiceInserted, hourInserted);
		prefS.persist(addedPreference);
		return "preferenceConfirmation.xhtml?faces-redirect=true";
	}

}
