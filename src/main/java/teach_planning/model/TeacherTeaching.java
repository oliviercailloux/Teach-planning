package teach_planning.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * Classe de lien entre Teaching et Teacher
 * Une matiere peut etre enseignee par plusieurs enseignants
 * Un enseignant peut enseigner plusieurs matiere
 *
 */
public class TeacherTeaching {
	 @Id
	 @ManyToOne(fetch=FetchType.LAZY)
	 private TeacherModel teacher;

	 @Id
	 @ManyToOne(fetch=FetchType.LAZY)
	 private TeachingModel teaching;

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

	 
}
