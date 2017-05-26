
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import teach_planning.model.LoginModel;
import teach_planning.model.TeacherModel;

import teach_planning.service.LoginService;
import teach_planning.service.TeacherService;


@RequestScoped
@Named
public class TeacherBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private String firstname;
    private String lastname;
    private String email;
    
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
	
    public String saveTeacher() {
    	
    	TeacherModel addedTeacher = new TeacherModel(firstname,lastname,email);
    	teacherS.persist(addedTeacher);
    	
		LoginModel newLogin = new LoginModel(email, "default");
		ls.persist(newLogin);
    	
    	return "teachconfirmation.xhtml?faces-redirect=false";
    }    

}

