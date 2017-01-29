package teach_planning.teaching;


import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ResearchTeaching {
	private ArrayList<Teaching> list = new ArrayList<Teaching>();

	HttpServletResponse resp;
	final ServletOutputStream out;

	public ResearchTeaching(HttpServletResponse resp) throws IOException {
		this.resp = resp;
		this.out = resp.getOutputStream();
		initlist();
	}


	public void initlist(){
		Teaching a = new Teaching("Java", 10, 10,5,5,2);
		Teaching b = new Teaching("SGBD", 15, 10, 5, 2, 1);
		Teaching c = new Teaching("KM",5,5,3,0,1);
		list.add(a);
		list.add(b);
		list.add(c);	
	}
	public void afficheform() throws IOException{
out.println("<html>");
		out.println("<body>");

		out.println("<form method='GET' name='searchTeaching' action='searchTeaching'>");
		out.println("<h1><span style='color: blue'>Teaching Research </span></h1></br>");
		out.println("<p>Please indicate the teaching for which you wish to obtain information :</p>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td><input type='text' id='Name' name='Name' /></td>");
		out.println("<td><input type='submit' value='Search' /></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<form method='GET' action='index.jsp'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td><input type='submit' value='Return to Homepage' /></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<html><br><span style='color: blue'> In order to help you, please find below a list of the existing teaching </span></br>");
		for(int i=0; i<list.size();i++){
			out.println("<br>"+list.get(i).getName()+"</br>");
		}
		out.println("</body>");
		out.println("</html>");
	}
	
	public void search(String teaching)throws IOException{
		boolean founded=false;
		for(int i=0; i<list.size();i++){
			if (list.get(i).getName().equals(teaching)){
				founded=true;
				out.println("<html>");
				out.println("<body>");
				out.println("<h1><span style='color: blue'> Teaching : "+teaching+"</span></h1>");
				out.println("	<p> Number of CM : "+list.get(i).getNbCM()+"</p>"
						+ "	<p> Number of TD : "+list.get(i).getNbTD()+"</p>"
						+ "	<p> Number of TP : "+list.get(i).getNbTP()+"</p>"
						+ "	<p> Number of CMTD : "+list.get(i).getNbCMTD()+"</p>"
						+ "	<p> Number of Groups : "+list.get(i).getNbGrp()+"</p>"
						+"<form method='GET'  action='index.jsp'><table><tr><td><input type='submit' value='Return to Homepage' /></td></tr></table></form>"

						+ "</body>"
						+"</html>");
			}
		}
		if(founded==false){
			out.println(
			"<html>"
			+ "<body>"
			+ "	<p> This teaching doesn't exist </p>"
			+"<form method='GET'  action='index.jsp'><table><tr><td><input type='submit' value='Return to Homepage' /></td></tr></table></form>"
			+"</body>"
			+"</html>");
		}
		
	}
}
