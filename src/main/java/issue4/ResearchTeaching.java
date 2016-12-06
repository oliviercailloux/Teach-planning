package issue4;


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
	public void search(String teaching)throws IOException{
		boolean founded=false;
		for(int i=0; i<list.size();i++){
			if (list.get(i).getName().equals(teaching)){
				founded=true;
				out.println("<h1> Teaching : "+teaching+"</h1>");
				out.println(
						"<html>"
						+ "<body>"
						+ "	<p> Number of CM : "+list.get(i).getCm()+"</p>"
						+ "	<p> Number of TD : "+list.get(i).getTd()+"</p>"
						+ "	<p> Number of TP : "+list.get(i).getTp()+"</p>"
						+ "	<p> Number of CMTD : "+list.get(i).getCmtd()+"</p>"
						+ "	<p> Number of Groups : "+list.get(i).getGrp()+"</p>"
						+ "</body>"
						+"</html>");
			}
		}
		if(founded==false){
			out.println(
			"<html>"
			+ "<body>"
			+ "	<p> This teaching doesn't exist </p>"
			+"</body>"
			+"</html>");
		}
		
	}
}
