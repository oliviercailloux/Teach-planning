package teacherPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class Print {
	
	HttpServletResponse response;
	final ServletOutputStream out;
	
	ArrayList<Teacher> lesProfs = new ArrayList<Teacher>();
	
	public Print(HttpServletResponse response) throws IOException {
		this.response = response;
		out = response.getOutputStream();

		lesProfs.add(new Teacher("AFGOUSTIDIS Alexandre"));
		lesProfs.add(new Teacher("AIRIAU Stephane"));
		lesProfs.add(new Teacher("AISSI Hassan"));
		
		lesProfs.get(0).addMatiere(new Matiere("Algebre lineaire 2", "CM", "D.E.1", 19.5 ,29.25 ));
		lesProfs.get(1).addMatiere(new Matiere("JAVA OBJET", "CM","L3 INFO", 18,27));
		lesProfs.get(1).addMatiere(new Matiere("INTELLIGENCE ARTIFICIELLE et raisonnement", "CM","M1 INFO", 18,27));
		lesProfs.get(1).addMatiere(new Matiere("PROJET JAVA", "CM","L3 INFO", 1.50,2.25));
		lesProfs.get(2).addMatiere(new Matiere("Décision ET analyse multicritère","CM","M1 INFO",18,27));
	}
	
	int findTeacher(String teacher) {
		for(int j=0;j<lesProfs.size();j++) {
			if (lesProfs.get(j).getNom().equals(teacher)) {
				return j; 
			}
		}
		return -1;
	}
	
	void printErrorNotFound(String teacher) throws IOException {
		out.println(
				"<html>"
				+ "	<body>"
				+ "<h1> Charge totale de l'enseignant : "+ teacher +"</h1>"
				+ "		<p>ERREUR : L'enseignant est inconnu. </p>"
				+ "	</body>"
				+ "</html>");		
	}
	
	void printCharge(String teacher, int indT) throws IOException{
		String toDisplay = "<html>"
				+ "<head><style>"
				+ "table {"
				+ "border-collapse: collapse;"
				+ "}"
				+ "table, td, th {"
				+ "    border: 1px solid black;"
				+ "}"
				+ "#titre {"
				+ "background-color: #A0D3EF;"
				+ "}"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<h1> Charge totale de l'enseignant : "+teacher+"</h1>"
				+ "<table>"
				+"<tr id='titre'><th>Nom matiere</th><th>Type</th><th>Diplome</th><th>Heures CM</th><th>Heures TD</th></tr>";

		StringBuilder sb = new StringBuilder(toDisplay);

		for(int k=0;k<lesProfs.get(indT).lesMatieres.size();k++) {
			sb.append(lesProfs.get(indT).lesMatieres.get(k).toString());
		}
	
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		String finaltoDisplay = sb.toString();
		
		out.println(finaltoDisplay);	
	}
	
	void printErrorRecup(String teacher) throws IOException{
		out.println(
				"<html>"
				+ "	<body>"
				+ "<h1> Charge totale de l'enseignant : </h1>"
				+ "		<p>ERREUR : L'enseignant n'est pas renseigné (nom et prénom manquants). </p>"
				+ "	</body>"
				+ "</html>");
	}
}
