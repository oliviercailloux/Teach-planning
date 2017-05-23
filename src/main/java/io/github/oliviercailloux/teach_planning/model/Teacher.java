package io.github.oliviercailloux.teach_planning.model;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity 
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
		
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_teaching", 
	joinColumns = @JoinColumn(name = "teacher_id", 
	referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "teaching_id", 
	referencedColumnName = "id"))
	private List<Teaching> teachings = new ArrayList<>();
	
	private String firstname, lastname, email;
	// pour le show charge teacher ... à refaire quand ce ne sera plus du code en dur
	private HashMap<String, Teaching> preferences = new HashMap<>();
	
	public Teacher() {
	}
	
	public Teacher(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
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

	public void addPreference(String choice, Teaching preference) {
		this.preferences.put(choice, preference);
	}
	
	public int getId(){
		return id;
	}
	
	public HashMap<String, Teaching> getPreferences() {
		return preferences;
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
	
	public List<Teaching> getTeachings(){
		return teachings;
	}
	
}