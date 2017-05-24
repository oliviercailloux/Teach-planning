import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import teach_planning.model.LoginModel;
import teach_planning.model.TeacherModel;
import teach_planning.service.LoginService;
import teach_planning.service.TeacherService;

@Named
@RequestScoped
public class TeacherBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private String firstName;
    private String lastName;
    private String email;
    
    @Inject
    private TeacherService teacherS;
    
    @Inject
    private LoginService ls;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String ln) {
        this.lastName = ln;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail( String m) {
        this.email = m;
    }
    
    public String saveTeacher() {

    	TeacherModel addedTeacher = new TeacherModel(firstName,lastName,email);
    	teacherS.persist(addedTeacher);
    	
		LoginModel newLogin = new LoginModel(email, "default");
		ls.persist(newLogin);
    	
    	return "teachconfirmation.xhtml?faces-redirect=false";
    }
}

