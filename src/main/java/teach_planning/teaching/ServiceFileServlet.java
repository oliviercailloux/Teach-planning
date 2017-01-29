package teach_planning.teaching;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
<<<<<<< HEAD:src/main/java/teachingPackage/ServiceFileServlet.java
import javax.inject.Inject;
=======

>>>>>>> origin:src/main/java/teach_planning/teaching/ServiceFileServlet.java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@WebServlet(name="ServiceFileServlet", urlPatterns={"/serviceFile"})
public class ServiceFileServlet extends HttpServlet {
	
	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		pw.println("<a href=\"jsps/serviceFile.jsp\">Générer une fiche de service pour un enseignant</a><br/>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Settings
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		// Getting Teacher parameters
		String civ = req.getParameter("civ");
		String teacherName = req.getParameter("teacherName");
		String teacherFirstName = req.getParameter("teacherFirstname");
		String status = req.getParameter("status");
		String discipline = req.getParameter("teachingSub");
		String email = req.getParameter("mail");
		
		//Displaying service file
		PrintWriter pw = resp.getWriter();
		pw.println("<html><script></script><body>");
		pw.println("<h1 style='color: blue;margin-left:30%;margin-bottom:25px;'>FICHE DE SERVICE 2016 - 2017 </h1>");
		pw.println("<table style='border-color:white; margin-left:7%;padding-left: 3%;'>"
				+ "<tr>"
				+ "<td>CIV</td><td>NOM</td><td>PRENOM</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td><div style='border: 3px solid black; padding: 3px 5px 3px 5px; margin-right:30%;'>" + civ.toUpperCase().toString() +"</div></td>"
				+ "<td><div width='800' style='border:3px solid black;  padding: 3px 200px 3px 5px; margin-right:30%;'>" + teacherName.toUpperCase().toString() +"</div></td>"
				+ "<td><div width='800' style='border:3px solid black;  padding: 3px 200px 3px 5px;'>" + teacherFirstName.toUpperCase().toString() +"</div></td>"
				+ "</tr>"
				+"<tr height='20' ><td></td></td><td></td></tr>"
				+"<tr>"
				+ "<td>STATUT <span style='border:3px solid black; padding: 3px 5px 3px 5px;' >"+ status.toUpperCase().toString() + "</span></td><td>DISCIPLINE <span style='border:3px solid black;padding: 3px 5px 3px 5px;' >"+ discipline.toUpperCase().toString() +"</span></td>"
				+"<td></td>"		
				+"</tr>"
				+"<tr height='20'><td></td></td><td></td></tr>"
				+ "<tr>"
				+ "<td>EMAIL <span style='border:3px solid black; padding: 3px 20px 3px 20px;' >" + email.toUpperCase().toString() + "</span></td> <td></td> <td></td>"
				+ "</tr>"
				+"<tr height='20'><td></td></td><td></td></tr>"
				+ "<tr>"
				+ "<td>PORTABLE</td><td>FIXE</td><td>POSTE</td>"
				+ "</tr>"
				+ "<td><div width='800' height='80' style='border:3px solid black; padding: 3px 5px 3px 5px;'>&nbsp;</div></td>"

				+ "<td><div width='800' style='color:white; border:3px solid black;  padding: 3px 200px 3px 5px; margin-right:30%;'>&nbsp;</div></td>"
				+ "<td><div width='800' height='80' style='border:3px solid black;  padding: 3px 5px 3px 5px;'>&nbsp;</div></td>"
				+ "</tr>"	
				+"<tr height='30'><td></td></td><td></td></tr>"
				+ "</table>");
		
		pw.println("<table width='900' style='border-collapse:collapse; border: 1px solid black; margin-left:8%;margin-bottom:50px;'>"
				+ "<tr  >"
				+ "<th  style='border: 1px solid black;text-align:center;padding: 3px 3px 3px 5px;' height='50' >ANNEE</th>"
				+ "<th style='border: 1px solid black;text-align:center;padding: 3px 3px 3px 5px;'  height='50'>ENSEIGNEMENTS</th>"
				+ "<th style='border: 1px solid black;text-align:center;padding: 3px 3px 3px 5px;'  height='50'> TYPE</th>"
				+"<th style='border: 1px solid black;text-align:center;padding: 3px 3px 3px 5px;'  height='50'> Nbr H</th>"
				+ "</tr>");
		
		for(int i=0;i<9;i++) {
			pw.println("<tr> <td style='border: 1px solid black;' >&nbsp;</td> <td style='border: 1px solid black;'>&nbsp;</td> <td style='border: 1px solid black;'>&nbsp;</td> <td style='border: 1px solid black;' >&nbsp;</td> </tr>" );
		};

		pw.println("</table>");
		
		pw.println("<div style='margin-left:55%;color:blue;'>TOTAL <span style='border:3px solid black; padding: 3px 200px 3px 20px;'>&nbsp;</span></div>");
		
		pw.println("<a href='javascript:window.print()'><h2>Imprimer la fiche service</h2></a>");
		
		
		
		pw.println("</body></html>");
		
	}
	
	
	
}
