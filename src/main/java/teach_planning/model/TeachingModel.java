package teach_planning.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TeachingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String name, typeMatiere, diplome;
	private double nbCM, nbTD, nbTP, nbCMTD, nbGrp;

	@OneToMany
	private ArrayList<TeachingModel> teachings;  
	
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
	
	public String getName() {
		return name;
	}
	
	public double getNbCM() {
		return nbCM;
	}
	
	public double getNbTD() {
		return nbTD;
	}
	
	public double getNbTP() {
		return nbTP;
	}
	
	public double getNbCMTD() {
		return nbCMTD;
	}
	
	public double getNbGrp() {
		return nbGrp;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNbCM(int nbCM) {
		this.nbCM = nbCM;
	}
	
	public void setNbTD(int nbTD) {
		this.nbTD = nbTD;
	}
	
	public void setNbTP(int nbTP) {
		this.nbTP = nbTP;
	}
	
	public void setNbCMTD(int nbCMTD) {
		this.nbCMTD = nbCMTD;
	}
	
	public void setNbGrp(int nbGrp) {
		this.nbGrp = nbGrp;
	}
	
	public String detailTeaching() {
		String mat = "<tr><td>" + this.name + "</td><td>" + 
	this.typeMatiere + "</td><td>" + this.diplome + "</td><td>" + this.nbCM + "</td><td>" + this.nbTD + "</td></tr>";
		return mat;
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
