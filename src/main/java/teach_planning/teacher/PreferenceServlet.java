package teach_planning.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import teach_planning.model.Teacher;
import teach_planning.model.Teaching;

@WebServlet(name="PreferenceServlet", urlPatterns={"/addPref"})
public class PreferenceServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
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
		
		try(PrintWriter pw=resp.getWriter()) {
			teacher.printPreferences(pw);
		} catch(Exception e) {
			Logger logger = Logger.getLogger(getClass().getName());
			logger.severe("Impossible to get writer from response in PreferenceServlet \n "
					+ "The error is : " + e);
		}
	}
	
}