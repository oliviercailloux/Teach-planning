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
public class TeachingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToMany(mappedBy="teachings")
	private List<TeacherModel> teachers = new ArrayList<>();
	
	private String name, typeMatiere, diplome;
	private double nbCM, nbTD, nbTP, nbCMTD, nbGrp;
	
	public TeachingModel() {
		
	}
	
	public TeachingModel(String name,int nbCM,int nbTD,int nbTP,int nbCMTD,int nbGrp){
		this.name = name;
		this.nbCM = nbCM;
		this.nbTD = nbTD;
		this.nbTP = nbTP;
		this.nbCMTD = nbCMTD;
		this.nbGrp = nbGrp;
	}

	public TeachingModel(String name, String typeMatiere, String diplome, double nbCM, double nbTD) {
		this.name = name;
		this.typeMatiere = typeMatiere;
		this.diplome = diplome;
		this.nbCM = nbCM;
		this.nbTD = nbTD; 
	}
	
	public TeachingModel(String nom, int nbH){
		this.name = nom;
		this.nbCMTD = nbH;
	}
	
	public String detailTeaching() {
		String mat = "<tr><td>" + this.name + "</td><td>" + 
	this.typeMatiere + "</td><td>" + this.diplome + "</td><td>" + this.nbCM + "</td><td>" + this.nbTD + "</td></tr>";
		return mat;
	}
	
	public int getId() {
		return id;
	}

	public List<TeacherModel> getTeachers() {
		return teachers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeMatiere() {
		return typeMatiere;
	}

	public void setTypeMatiere(String typeMatiere) {
		this.typeMatiere = typeMatiere;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
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

	public void setNbGrp(double nbGrp) {
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