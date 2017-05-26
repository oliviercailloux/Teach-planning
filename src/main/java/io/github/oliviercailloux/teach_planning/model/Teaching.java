package io.github.oliviercailloux.teach_planning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teaching {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teaching")
	private List<Assignment> teachers = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teaching")
	private List<Preference> teachersPref = new ArrayList<>();
	
	private String name, teachingType, degree;
	private double nbCM, nbTD, nbTP, nbCMTD;
	private int nbGrp;
	
	public Teaching() {
		
	}
	
	public Teaching(String name, String teachingType, String degree, double nbCM, double nbTD, double nbTP,double nbCMTD,int nbGrp) {
		this.name = name;
		this.teachingType = teachingType;
		this.degree = degree;
		this.nbCM = nbCM;
		this.nbTD = nbTD; 
		this.nbTP = nbTP;
		this.nbCMTD = nbCMTD;
		this.nbGrp = nbGrp;
	}
	
	/**
	 * @TODO
	 * CORRIGER LA SERVLET SHOWCHARGETEACHERSERVLET DE TEACHER QUI EST POURRIE
	 */
	public String detailTeaching() {
		return "<tr><td>" + this.name + "</td><td>" + 
		this.teachingType + "</td><td>" + this.degree + "</td><td>" + this.nbCM + "</td><td>" + this.nbTD + "</td></tr>";
	}
	
	public int getId() {
		return id;
	}

	public List<Assignment> getTeachers() {
		return teachers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(String teachingType) {
		this.teachingType = teachingType;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public double getNbCM() {
		return nbCM;
	}

	public void setNbCM(double nbCM) {
		this.nbCM = nbCM;
	}

	public double getNbTD() {
		return nbTD;
	}

	public void setNbTD(double nbTD) {
		this.nbTD = nbTD;
	}

	public double getNbTP() {
		return nbTP;
	}

	public void setNbTP(double nbTP) {
		this.nbTP = nbTP;
	}

	public double getNbCMTD() {
		return nbCMTD;
	}

	public void setNbCMTD(double nbCMTD) {
		this.nbCMTD = nbCMTD;
	}

	public double getNbGrp() {
		return nbGrp;
	}

	public void setNbGrp(int nbGrp) {
		this.nbGrp = nbGrp;
	}
	
	public List<Preference> getTeachersPref() {
		return teachersPref;
	}

	public void setTeachersPref(List<Preference> teachersPref) {
		this.teachersPref = teachersPref;
	}

	public void setTeachers(List<Assignment> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return(getName() +" - "+getDegree());
	}
	
}