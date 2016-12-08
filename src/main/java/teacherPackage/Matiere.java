package teacherPackage;

public class Matiere {
	
	public String nomMatiere;
	public String typeMatiere;
	public String diplome;
	public double nbCM; //Nombre d'heure de CM
	public double nbTD; //Nombre d'heure de TD


	public Matiere(String n, String t, String d, double e, double f) {
		this.nomMatiere = n;
		this.typeMatiere = t;
		this.diplome = d;
		this.nbCM = e;
		this.nbTD = f; 
	}
	
	@Override
	public String toString() {
		String mat = "<tr><td>" + this.nomMatiere + "</td><td>" + 
	this.typeMatiere + "</td><td>" + this.diplome + "</td><td>" + this.nbCM + "</td><td>" + this.nbTD + "</td></tr>";
		return mat;
	}
}
