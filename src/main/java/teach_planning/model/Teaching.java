package teach_planning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teaching {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToMany(mappedBy="teachings")
	private List<Teacher> teachers = new ArrayList<>();
	
	private String name, teachingType, degree;
	private double nbCM, nbTD, nbTP, nbCMTD;
	private int nbGrp;
	
	public Teaching() {
		
	}
	
	public Teaching(String name,int nbCM,int nbTD,int nbTP,int nbCMTD,int nbGrp){
		this.name = name;
		this.nbCM = nbCM;
		this.nbTD = nbTD;
		this.nbTP = nbTP;
		this.nbCMTD = nbCMTD;
		this.nbGrp = nbGrp;
	}

	public Teaching(String name, String teachingType, String degree, double nbCM, double nbTD) {
		this.name = name;
		this.teachingType = teachingType;
		this.degree = degree;
		this.nbCM = nbCM;
		this.nbTD = nbTD; 
	}
	
	/**
	 * @TODO
	 * CORRIGER LA SERVLET PREFERENCESERVLET DE TEACHER QUI EST POURRIE
	 */
	public Teaching(String name, int nbH){
		this.name = name;
		this.nbCMTD = nbH;
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

	public List<Teacher> getTeachers() {
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

	@Override
	public String toString() {
		return(this.getName() + " est composée de " + getNbGrp() + " groupes et est décomposée comme suit : <br />" + 
				getNbCM() + " heures de cours magistraux <br />" +
				getNbTD() + " heures de cours de travaux dirigés <br />" +
				getNbTP() + " heures de cours de travaux pratiques <br />" +
				getNbCMTD() + " heures de cours mix CM/TD <br />");
	}
	
}