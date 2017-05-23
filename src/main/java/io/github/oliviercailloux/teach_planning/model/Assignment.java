package io.github.oliviercailloux.teach_planning.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@IdClass(AssignmentId.class)
public class Assignment {

	@Id
	private int teacherId;
	@Id
	private int teachingId;

	@ManyToOne
	@PrimaryKeyJoinColumn(name="teacherId", referencedColumnName="id")
	private Teacher teacher;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="teachingId", referencedColumnName="id")
	private Teaching teaching;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getTeachingId() {
		return teachingId;
	}

	public void setTeachingId(int teachingId) {
		this.teachingId = teachingId;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teaching getTeaching() {
		return teaching;
	}

	public void setTeaching(Teaching teaching) {
		this.teaching = teaching;
	}

	@Override
	public String toString() {
		return "Assignment [nomEnseignant=" + this.teacher.getLastname() + ", prenomEnseignant=" + this.teacher.getFirstname() + ", matière="
				+ this.teaching.getName()+"]"+"\n";
	}
}