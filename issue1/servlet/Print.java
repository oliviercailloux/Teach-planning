package servlet;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class Print {
	
	HttpServletResponse response;
	final ServletOutputStream out;
	
	public Print(HttpServletResponse response) throws IOException {
		this.response = response;
		out = response.getOutputStream();
	}
	
	void printCharge(String teacher) throws IOException{
		out.println("<h1> Charge totale de l'enseignant : "+teacher+"</h1>");
		out.println(
				"<html>"
				+ "<body>"
				+ "	<p> R�cup�rer les charges du prof.</p>"
				+ "</body>"
				+"</html>");
	}
	
	void printErrorRecup(String teacher) throws IOException{
		out.println(
				"<html>"
				+ "	<body>"
				+ "		<p>L'enseignant renseign� n'est pas renseign� : teacher = " + teacher + "</p>"
				+ "	</body>"
				+ "</html>");
	}
}
