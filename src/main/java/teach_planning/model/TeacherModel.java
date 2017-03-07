package teach_planning.model;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import teach_planning.teaching.Teaching;

@Entity
public class TeacherModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String firstname, lastname, email;
	
	public TeacherModel() {
		
	}
	
	public TeacherModel(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	private ArrayList<Teaching> teachings = new ArrayList<>();  
	// pour le show charge teacher ... à refaire quand ce ne sera plus du code en dur
	private HashMap<String, Teaching> preferences = new HashMap<>();
	
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
		this.teachings.add(t);
	}
	
	public ArrayList<Teaching> getTeachings(){
		return teachings;
	}
	
	@Override
	public String toString() {
		return(this.getFirstname() + " " + this.getLastname() 
			+ " <i>"+this.getEmail()+"</i>");
	}
	
	public void printPreferences (PrintWriter pw){
		pw.println("La liste de mes préferences :<br/>");
		for(Entry<String, Teaching> entry : preferences.entrySet()) {
		    String key = entry.getKey();
		    Teaching value = entry.getValue();
		    pw.println("La matière "+value.getName()+" est le "+key+"<br />");
		}
	    pw.println("<a href=\"index.jsp\"> Retour à l'accueil </a>");
	}
	
	public HashMap<String, Teaching> getPreferences() {
		return preferences;
	}

	public void addPreference(String choix, Teaching preference) {
		this.preferences.put(choix, preference);
	}
	
}