package io.github.oliviercailloux.teach_planning;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.service.TeacherService;

@ManagedBean
@RequestScoped
public class TeacherRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext
	private EntityManager em;
	
	private String nom;
	private String prenom;
	private String email;
	private String teacher1;
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getTeacher1() {
		return teacher1;
	}

	public void setTeacher1(String teacher1) {
		this.teacher1 = teacher1;
	}

	private Teacher teacher;
	
	private List<Teacher> teachers;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Inject
	private TeacherService teacherS;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public TeacherService getTeacherS() {
		return teacherS;
	}

	public void setTeacherS(TeacherService teacherS) {
		this.teacherS = teacherS;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	@PostConstruct
	public void init(){
		teachers = teacherS.getAll();
		//this.email = teachers.get(1).getEmail();
		int k = teachers.size();
		/*
		for(int i =0; i<k; i++){
			teacher = teachers.get(i);
			if((teacher.getFirstname().equalsIgnoreCase(prenom))||(teacher.getLastname().equalsIgnoreCase(nom))){
				//this.teacher = t;
				this.email = "a";
				this.email = teacher.getEmail();
				this.email = "b";
			}
			else
				this.email = "NotFound";
		}
		*/
		/*
		for(Teacher t : teachers) {
			if((t.getFirstname().equalsIgnoreCase(this.prenom))|(t.getLastname().equalsIgnoreCase(this.nom))){
				this.teacher = t;
				this.email = "a";
			}	
			
		}
		*/
		
	}
	
	public Teacher getTeacher(){
		return teacher;
	}
	
	public String saveTeacher(){
		init();
		teacher = em.find(Teacher.class, Integer.parseInt(teacher1));
		this.email = teacher.getEmail();
		this.nom = teacher.getLastname();
		this.prenom = teacher.getFirstname();
		return "serviceFilePre.xhtml?faces-redirect=false";
	}
}
