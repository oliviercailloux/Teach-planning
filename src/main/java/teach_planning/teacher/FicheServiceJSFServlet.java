package teach_planning.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teach_planning.model.TeacherModel;


@WebServlet(name="ServiceFileJSFServlet")
public class FicheServiceJSFServlet extends HttpServlet {
	
	TeacherRequest tr;
	TeacherModel teacher;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tr.init();
		teacher = tr.getTeacher();
		request.getRequestDispatcher("../ServiFicheJSF.xhtml");
		
		
	}

}
