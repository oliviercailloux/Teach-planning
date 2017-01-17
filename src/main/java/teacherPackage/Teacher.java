package teacherPackage;

import java.util.ArrayList;

import teachingPackage.Teaching;

public class Teacher {
	
	private String firstname; 
	private String lastname; 
	private String email;
	private  ArrayList<Teaching> teachingList;  
	
	public Teacher(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.teachingList = new ArrayList<Teaching>();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addTeaching(Teaching t) {
		this.teachingList.add(t);
	}
	
	
	@Override
	public String toString() {
		return(this.getFirstname() + " " + this.getLastname() + 
				" <i>"+this.getEmail()+"</i>");
	}
	
	// OBSOLETE MAIS SI JE GARDE PAS ERREUR DANS CLASSE PRINT
	private String nom;
	ArrayList<Matiere> lesMatieres; 
	public Teacher(String n) {
		this.nom = n;
	}
	public String getNom() {
		return this.nom;
	}
	public void addMatiere(Matiere m) {
		this.lesMatieres.add(m);	
	}
}
