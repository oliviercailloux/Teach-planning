package teach_planning.teaching;

import teach_planning.model.TeacherModel;
import teach_planning.model.TeachingModel;

public class Assignment {

	private TeacherModel teacher;
	private TeachingModel teaching;
	private String teachingType;
	private String promotion;
	
	public Assignment(TeacherModel teacher2, TeachingModel teaching, String teachingType, String promotion) {
		this.teacher = teacher2;
		this.teaching = teaching;
		this.teachingType = teachingType;
		this.promotion = promotion;
	}

	public TeacherModel getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherModel teacher) {
		this.teacher = teacher;
	}

	public TeachingModel getTeaching() {
		return teaching;
	}

	public void setTeaching(TeachingModel teaching) {
		this.teaching = teaching;
	}

	public String getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(String teachingType) {
		this.teachingType = teachingType;
	}
	
	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	@Override
	public String toString() {
		return "Assignment [nomEnseignant=" + this.teacher.getLastname() + ", prenomEnseignant=" + this.teacher.getFirstname() + ", matière="
				+ this.teaching.getName() + ", typeEnseignement=" + this.teachingType + ", promotion=" + this.promotion + "]"+"\n";
	}
}
