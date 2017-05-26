package io.github.oliviercailloux.teach_planning.teacher.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.oliviercailloux.teach_planning.model.Teacher;


@WebServlet(name="ServiceFileJSFServlet")
public class FicheServiceJSFServlet extends HttpServlet {
	
	//TeacherRequest tr;
	Teacher teacher;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tr.init();
		//teacher = tr.getTeacher();
		request.getRequestDispatcher("../ServiFicheJSF.xhtml");
		
		
	}

}
