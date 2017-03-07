package teach_planning;


import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teach_planning.login.Login;
import teach_planning.login.LoginAdmin;
import teach_planning.login.LoginServlet;
import teach_planning.model.LoginModel;
import teach_planning.model.TeacherModel;
import teach_planning.model.TeachingModel;
import teach_planning.model.TypeAccount;
import teach_planning.service.LoginService;
import teach_planning.service.TeacherService;
import teach_planning.service.TeachingService;
import teach_planning.teacher.Teacher;
import teach_planning.teacher.TeacherServlet;
import teach_planning.teaching.Teaching;
import teach_planning.teaching.TeachingServlet;

@WebServlet(name="InitServlet", loadOnStartup=1, urlPatterns={"/initLists"})
public class InitServlet extends HttpServlet {

	/**
	 * DEFAULT
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	public LoginService ls;
	
	@Inject
	public TeacherService ts;
	
	@Inject
	public TeachingService tgs;
	
	@Override
	public void init() throws ServletException {
		//Create the persistent logins for administrators
		ls.persist(new LoginModel("cathy.marques@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new LoginModel("mathilde.masson@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new LoginModel("alessandro.quaresima@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new LoginModel("amelie.quach@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new LoginModel("abdoulaye.diarra@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new LoginModel("sandratra.razafiniaina@test.com", "root", TypeAccount.ADMINISTRATOR));
		//Create the persistent logins for teachers
		ls.persist(new LoginModel("jean.martin@test.com", "default", TypeAccount.TEACHER));
		ls.persist(new LoginModel("jack.martin@test.com", "default", TypeAccount.TEACHER));
		ls.persist(new LoginModel("paul.martin@test.com", "default", TypeAccount.TEACHER));
		
		//Create the persistent teachers
		ts.persist(new TeacherModel("jean", "martin", "jean.martin@test.com"));
		ts.persist(new TeacherModel("jack", "martin", "jack.martin@test.com"));
		ts.persist(new TeacherModel("paul", "martin", "paul.martin@test.com"));
		
		//Create the persistent teachings
		tgs.persist(new TeachingModel("Java", 20, 10, 15, 0, 2));
		tgs.persist(new TeachingModel("Communication", 10, 10, 0, 10, 1));
		tgs.persist(new TeachingModel("Analyse de données", 30, 0, 0, 5, 4));
		
		
		// Clean the admin list when new call is done (avoid duplicate)
		LoginServlet.loginAdmin = new ArrayList<>();
		LoginServlet.loginAdmin.add(new LoginAdmin("cathy.marques@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("mathilde.masson@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("alessandro.quaresima@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("amelie.quach@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("abdoulaye.diarra@test.com", "root"));
		LoginServlet.loginAdmin.add(new LoginAdmin("sandratra.razafiniaina@test.com", "root"));

		// Clean the teacher list and teacher login list when new call is done (avoid duplicate)
		TeacherServlet.teacherList = new ArrayList<>();
		TeacherServlet.teacherList.add(new Teacher("jean", "martin", "jean.martin@test.com"));
		TeacherServlet.teacherList.add(new Teacher("jack", "martin", "jack.martin@test.com"));
		TeacherServlet.teacherList.add(new Teacher("paul", "martin", "paul.martin@test.com"));

		LoginServlet.loginList = new ArrayList<>();
		LoginServlet.loginList.add(new Login("jean.martin@test.com", "default"));
		LoginServlet.loginList.add(new Login("jack.martin@test.com", "default"));
		LoginServlet.loginList.add(new Login("paul.martin@test.com", "default"));

		// Clean the teaching list when new call is done (avoid duplicate)
		TeachingServlet.teachingList = new ArrayList<>();
		TeachingServlet.teachingList.add(new TeachingModel("Java", 20, 10, 15, 0, 2));
		TeachingServlet.teachingList.add(new TeachingModel("Communication", 10, 10, 0, 10, 1));
		TeachingServlet.teachingList.add(new TeachingModel("Analyse de données", 30, 0, 0, 5, 4));
	}
	
}