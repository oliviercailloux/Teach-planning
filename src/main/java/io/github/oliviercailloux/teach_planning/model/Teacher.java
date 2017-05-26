package io.github.oliviercailloux.teach_planning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
	private List<Assignment> teachings;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
	private List<Preference> preferences;
	
	private String firstname, lastname, email;
	
	public Teacher() {
	}
	
	public Teacher(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		preferences = new ArrayList<>();
		teachings = new ArrayList<>();
	}
	
	public int getId(){
		return id;
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
	
	public List<Assignment> getTeachings(){
		return teachings;
	}

	public List<Preference> getPreferences() {
		return preferences;
	}
	
	@Override
	public String toString() {
		return(getFirstname() + " " + getLastname());
	}

}