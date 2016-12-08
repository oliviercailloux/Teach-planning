package teacherPackage;

import java.util.ArrayList;

public class Teacher {
	
	private String nom; 
	public  ArrayList<Matiere> lesMatieres;  
	
	public Teacher(String n) {
		this.nom = n;
		this.lesMatieres = new ArrayList<Matiere>();
	}
	
	public void addMatiere(Matiere m) {
		this.lesMatieres.add(m);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	@Override
	public String toString() {

		String mat = "";
		StringBuilder sb = new StringBuilder(mat);
		
		for(int i=0;i<this.lesMatieres.size(); i++) {
			sb.append(lesMatieres.get(i).toString());
		}
		return sb.toString();
	}
	
	
}
