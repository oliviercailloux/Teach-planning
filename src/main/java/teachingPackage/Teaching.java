package teachingPackage;

public class Teaching {
	
	private String name;

	private int NbCM, NbTD, NbTP, NbCMTD, NbGrp;
	
	public Teaching(String name,int NbCM,int NbTD,int NbTP,int NbCMTD,int NbGrp){
		this.name = name;
		this.NbCM = NbCM;
		this.NbTD = NbTD;
		this.NbTP = NbTP;
		this.NbCMTD = NbCMTD;
		this.NbGrp = NbGrp;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNbCM() {
		return NbCM;
	}
	
	public int getNbTD() {
		return NbTD;
	}
	
	public int getNbTP() {
		return NbTP;
	}
	
	public int getNbCMTD() {
		return NbCMTD;
	}
	
	public int getNbGrp() {
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
	
	@Override
	public String toString() {
		return(this.getName() + " est composée de " + getNbGrp() + " groupes et est décomposée comme suit : <br />" + 
				getNbCM() + " heures de cours magistraux <br />" +
				getNbTD() + " heures de cours de travaux dirigés <br />" +
				getNbTP() + " heures de cours de travaux pratiques <br />" +
				getNbCMTD() + " heures de cours mix CM/TD <br />");
	}
	
}
