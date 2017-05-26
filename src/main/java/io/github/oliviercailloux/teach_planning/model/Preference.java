package io.github.oliviercailloux.teach_planning.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@IdClass(PreferenceId.class)
public class Preference {

	@Id
	private int teacherId;
	@Id
	private int teachingId;
	@Id
	@Enumerated(EnumType.STRING)
	private Choice choice;
	private int nbHour;

	@ManyToOne
	@PrimaryKeyJoinColumn(name="teacherId", referencedColumnName="id")
	private Teacher teacher;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="teachingId", referencedColumnName="id")
	private Teaching teaching;
	
	public Preference() {
	}
	
	public Preference(Teacher teacher, Teaching teaching, Choice choice, int nbHour) {
		this.teacherId = teacher.getId();
		this.teachingId = teaching.getId();
		this.choice = choice;
		this.nbHour = nbHour;
		teacher.getPreferences().add(this);
		teaching.getTeachersPref().add(this);
	}
	
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

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public int getNbHour() {
		return nbHour;
	}

	public void setNbHour(int nbHour) {
		this.nbHour = nbHour;
	}
	
	
}