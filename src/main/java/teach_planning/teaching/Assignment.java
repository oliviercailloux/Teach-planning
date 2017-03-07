package teach_planning.teaching;

import teach_planning.model.TeachingModel;
import teach_planning.teacher.Teacher;

public class Assignment {

	private Teacher teacher;
	private TeachingModel teaching;
	private String teachingType;
	private String promotion;
	
	public Assignment(Teacher teacher, TeachingModel teaching, String teachingType, String promotion) {
		this.teacher = teacher;
		this.teaching = teaching;
		this.teachingType = teachingType;
		this.promotion = promotion;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
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
