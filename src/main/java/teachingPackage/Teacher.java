package teachingPackage;

import java.util.ArrayList;

public class Teacher {

	private String nom, prenom;
	
	private ArrayList<String> preferences;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void getPreferences() {
		System.out.println("La liste de mes préferneces :");
		for(String s : preferences) {
			System.out.println(s);
		}	
	}

	public void setPreferences(String preferences) {
		this.preferences.add(preferences);
		
	}
	
	
}
