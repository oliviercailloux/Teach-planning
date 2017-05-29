package io.github.oliviercailloux.teach_planning.teacher.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.github.oliviercailloux.teach_planning.model.Assignment;
import io.github.oliviercailloux.teach_planning.model.ChargeTeacher;
import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.service.ChargeService;
import io.github.oliviercailloux.teach_planning.service.TeacherService;

@ManagedBean
@RequestScoped
public class ChargeBean implements Serializable {
	
	@PersistenceContext
	private EntityManager em;
	
	private int teacherId;
	private int chargeTotale;
	
	private ChargeTeacher chargeT;
	
	private List<Teacher> teachers;
	private List<ChargeTeacher> allCharges;
	
	@Inject
	private TeacherService tS;
	
	@Inject
	private ChargeService cS;
	
    @PostConstruct
    public void init() {
		teachers = tS.getAll();
		allCharges = cS.getAll();
	}
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public int getChargeTotale() {
		return this.chargeTotale;
	}
	
	public void setChargeTotale(int ct) {
		this.chargeTotale = ct;
	}
	
    public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public List<ChargeTeacher> getAllCharges(){
		return this.allCharges;
	}
	
	public void setAllCharges(List<ChargeTeacher> allC) {
		this.allCharges = allC;
	}
	
	public ChargeTeacher getChargeT() {
		return this.chargeT;
	}
	
	public void setChargeT(ChargeTeacher cTeach) {
		this.chargeT = cTeach;
	}
	
	public String saveChargeTeacher() {
		Teacher teacher = em.find(Teacher.class, this.teacherId);	
		this.chargeT = new ChargeTeacher(teacher,this.chargeTotale);
		
		cS.persist(this.chargeT);
		
		return "nbHoursConfirm.xhtml?faces-redirect=false";
	}
}
