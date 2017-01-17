package teacherPackage;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import teachingPackage.Teaching;

public class Teacher {
	
	private String firstname; 
	private String lastname; 
	private String email;
	private  ArrayList<Teaching> teachingList;  
	
	private String nom;
	
	public Teacher(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.teachingList = new ArrayList<Teaching>();
	}
	
	public Teacher(String n) {
		this.nom = n;
		this.teachings = new ArrayList<Teaching>();
		this.preferences = new HashMap<String, Teaching>();
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
	
	private ArrayList<Teaching> teachings;  
	private HashMap<String,Teaching> preferences;
	
	public void addMatiere(Teaching m) {
		this.teachings.add(m);
	}
	
	public ArrayList<Teaching> getTeachings(){
		return teachings;
	}
	
	public void addTeaching(Teaching t) {
		this.teachingList.add(t);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void printPreferences (PrintWriter pw){
		pw.println("La liste de mes préferences :");
		for(Entry<String, Teaching> entry : preferences.entrySet()) {
		    String key = entry.getKey();
		    Teaching value = entry.getValue();
		    pw.println("La matière "+value+" est le "+key+"<br />");
		}
	}
	
	public HashMap<String, Teaching> getPreferences() {
		return preferences;
	}

	public void addPreference(String choix, Teaching preference) {
		this.preferences.put(choix, preference);
	}
	
	@Override
	public String toString() {
		return(this.getFirstname() + " " + this.getLastname() 
			+ " <i>"+this.getEmail()+"</i>");
	}
	
	// CODE QUI VIENT DE DIEU SEUL SAIT
	/*public String getDetailTeaching() {
		String mat = "";
		StringBuilder sb = new StringBuilder(mat);
		
		for(int i=0;i<this.teachings.size(); i++) {
			sb.append(teachings.get(i).detailTeaching());
		}
		return sb.toString();
	}*/

}
