package io.github.oliviercailloux.teach_planning.teacher.bean;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.github.oliviercailloux.teach_planning.model.Login;
import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.TypeAccount;
import io.github.oliviercailloux.teach_planning.service.LoginService;
import io.github.oliviercailloux.teach_planning.service.TeacherService;


@ManagedBean
@RequestScoped
public class TeacherBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private String firstname;
    private String lastname;
    private String email;
    private List<Teacher> teachings = new ArrayList<>();
    
    @Inject
    private TeacherService teacherS;
    
    @Inject
    private LoginService ls;

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String fn) {
        this.firstname = fn;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName( String ln) {
        this.lastname = ln;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail( String m) {
        this.email = m;
    }
    
	public List<Teacher> getTeachings(){
		return teachings;
	}
	
	public void setTeachings(List<Teacher> list) {
		this.teachings = list;
	}
	
    public String saveTeacher() {
    	
    	Teacher addedTeacher = new Teacher(firstname,lastname,email);
    	teacherS.persist(addedTeacher);
    	
    	this.setTeachings(teacherS.getTeachings());
    	
		Login newLogin = new Login(email, "default",TypeAccount.TEACHER);
		ls.persist(newLogin);
    	
    	return "teachconfirmation.xhtml?faces-redirect=false";
    }    

}