package io.github.oliviercailloux.teach_planning.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ChargeTeacher {
	
	@Id
	private int teacherId;
	
	private int chargeTotale;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="teacherId", referencedColumnName="id")
	private Teacher teacher;
	
	public ChargeTeacher() {
	}
	
	public ChargeTeacher(Teacher teacher, int chargeT) {
		teacherId = teacher.getId();
		chargeTotale = chargeT;
	}
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public int getChargeTotal() {
		return this.chargeTotale;
	}
	
	public void setChargeTotal(int ct) {
		this.chargeTotale = ct;
	}
	
	public Teacher getTeacher() {
		return this.teacher;
	}
	
	public void setTeacher(Teacher tt) {
		this.teacher = tt;
	}
}
