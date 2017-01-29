package teach_planning.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import teach_planning.teaching.Teaching;

@WebServlet(name="PreferenceServlet", urlPatterns={"/addPref"})
public class PreferenceServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	@Inject
	private PrintChoiceInterface print;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		PrintWriter pw=resp.getWriter();
		
		pw.println("<a href=\"jsps/prefView/prefForm.jsp\">Ajouter une préference</a><br/>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_HTML);
		resp.setLocale(Locale.FRENCH);
		
		Teacher teacher = new Teacher("Toto", "Titi", "Tata");
		
		String matiere = "M";
		String choix = "choix";
		String heure = "H";
		
		for(int i = 1; i<39; i++){
			//String verif;
			choix= choix+i;
			
			if(!req.getParameter(choix).equals("choix0")){
				matiere = matiere+i;
				heure = heure+i;
				int h = Integer.parseInt(req.getParameter(heure));
				
				Teaching teaching = new Teaching(req.getParameter(matiere), h);
				teacher.addPreference(req.getParameter(choix), teaching);
			}
			choix = "choix";
			heure = "H";
			matiere = "M";
		}
		
		//String choix = req.getParameter("choix1");
		//Teaching teaching = new Teaching("RaN", "CM", "M1 INFO", 18.0, 27.0);
		//teacher.addPreference(choix, teaching);
		
		PrintWriter pw=resp.getWriter();
		//pw.println(choix);
		
		print.printPreferences(pw, teacher);
	}
}
