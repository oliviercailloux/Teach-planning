package teachingPackage;

public class Teaching {
	
	private String name;
	public String typeMatiere;
	public String diplome;
	private double NbCM, NbTD, NbTP, NbCMTD, NbGrp;
	
	public Teaching(String name,int NbCM,int NbTD,int NbTP,int NbCMTD,int NbGrp){
		this.name = name;
		this.NbCM = NbCM;
		this.NbTD = NbTD;
		this.NbTP = NbTP;
		this.NbCMTD = NbCMTD;
		this.NbGrp = NbGrp;
	}

	public Teaching(String n, String t, String d, double e, double f) {
		this.name = n;
		this.typeMatiere = t;
		this.diplome = d;
		this.NbCM = e;
		this.NbTD = f; 
	}
	
	public String getName() {
		return name;
	}
	
	public double getNbCM() {
		return NbCM;
	}
	
	public double getNbTD() {
		return NbTD;
	}
	
	public double getNbTP() {
		return NbTP;
	}
	
	public double getNbCMTD() {
		return NbCMTD;
	}
	
	public double getNbGrp() {
		return NbGrp;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNbCM(int nbCM) {
		NbCM = nbCM;
	}
	
	public void setNbTD(int nbTD) {
		NbTD = nbTD;
	}
	
	public void setNbTP(int nbTP) {
		NbTP = nbTP;
	}
	
	public void setNbCMTD(int nbCMTD) {
		NbCMTD = nbCMTD;
	}
	
	public void setNbGrp(int nbGrp) {
		NbGrp = nbGrp;
	}
	
	public String detailTeaching() {
		String mat = "<tr><td>" + this.name + "</td><td>" + 
	this.typeMatiere + "</td><td>" + this.diplome + "</td><td>" + this.NbCM + "</td><td>" + this.NbTD + "</td></tr>";
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
