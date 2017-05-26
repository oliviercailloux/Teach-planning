package io.github.oliviercailloux.teach_planning;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.service.TeacherService;

@Named
@RequestScoped
public class TeacherRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private String prenom;
	
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

	private Teacher teacher;
	
	public void init(){
		for(Teacher t : teacherS.getAll()) {
			if((t.getFirstname()==this.prenom)&&(t.getLastname()==this.nom))
				this.teacher = t;
		}
	}
	
	public Teacher getTeacher(){
		return teacher;
	}
	
	public String saveTeacher(){
		init();
		return "xhtml/serviceFilePre.xhtml?faces-redirect=true";
	}
}
