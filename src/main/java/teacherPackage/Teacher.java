package teacherPackage;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.enterprise.context.*;

import teachingPackage.Teaching;

public class Teacher{
	
	private String nom; 
	private ArrayList<Teaching> teachings;  
	private HashMap<String,Teaching> preferences;
	
	public Teacher(String n) {
		this.nom = n;
		this.teachings = new ArrayList<Teaching>();
		this.preferences = new HashMap<String, Teaching>();
	}
	
	public void addMatiere(Teaching m) {
		this.teachings.add(m);
	}
	
	public ArrayList<Teaching> getTeachings(){
		return teachings;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void printPreferences (PrintWriter pw){
		pw.println("La liste de mes préferences :");
		for(Entry<String, Teaching> entry : preferences.entrySet()) {
		    String key = entry.getKey();
		    Teaching value = entry.getValue();
		    pw.println("La matière "+value+" est le "+key);
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

		String mat = "";
		StringBuilder sb = new StringBuilder(mat);
		
		for(int i=0;i<this.teachings.size(); i++) {
			sb.append(teachings.get(i).detailTeaching());
		}
		return sb.toString();
	}
	
	
}
