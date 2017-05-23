package teach_planning.teacher;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import teach_planning.model.TeacherModel;
import teach_planning.service.TeacherService;

@RequestScoped
@Named
public class TeacherRequest {
	
	private String nom;
	private String prenom;
	
	private TeacherService teacherS;
	
	private TeacherModel teacher;
	
	public void init(){
		for(TeacherModel t : teacherS.getAll()) {
			if((t.getFirstname()==this.prenom)&&(t.getLastname()==this.nom))
				this.teacher = t;
		}
	}
	
	public TeacherModel getTeacher(){
		return teacher;
	}
	

}
