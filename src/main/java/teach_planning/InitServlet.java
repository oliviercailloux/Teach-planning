package teach_planning;


import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import teach_planning.login.Login;
import teach_planning.login.LoginAdmin;
import teach_planning.login.LoginServlet;
import teach_planning.teacher.Teacher;
import teach_planning.teacher.TeacherServlet;
import teach_planning.teaching.Teaching;
import teach_planning.teaching.TeachingServlet;

@WebServlet(name="InitServlet", urlPatterns={"/initLists"})
public class InitServlet extends HttpServlet {

	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// Clean the admin list when new call is done (avoid duplicate)
		LoginServlet.loginAdmin = new ArrayList<Login>();
		LoginServlet.loginAdmin.add(new LoginAdmin("cathy.marques@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("mathilde.masson@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("alessandro.quaresima@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("amelie.quach@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("abdoulaye.diarra@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("sandratra.razafiniaina@test.com", "root"));

		// Clean the teacher list and teacher login list when new call is done (avoid duplicate)
		TeacherServlet.teacherList = new ArrayList<Teacher>();
		TeacherServlet.teacherList.add(new Teacher("jean", "martin", "jean.martin@test.com"));
		TeacherServlet.teacherList.add(new Teacher("jack", "martin", "jack.martin@test.com"));
		TeacherServlet.teacherList.add(new Teacher("paul", "martin", "paul.martin@test.com"));

		LoginServlet.loginList = new ArrayList<Login>();
		LoginServlet.loginList.add(new Login("jean.martin@test.com", "default"));
		LoginServlet.loginList.add(new Login("jack.martin@test.com", "default"));
		LoginServlet.loginList.add(new Login("paul.martin@test.com", "default"));

		// Clean the teaching list when new call is done (avoid duplicate)
		TeachingServlet.teachingList = new ArrayList<Teaching>();
		TeachingServlet.teachingList.add(new Teaching("Java", 20, 10, 15, 0, 2));
		TeachingServlet.teachingList.add(new Teaching("Communication", 10, 10, 0, 10, 1));
		TeachingServlet.teachingList.add(new Teaching("Analyse de données", 30, 0, 0, 5, 4));
	}
	
}