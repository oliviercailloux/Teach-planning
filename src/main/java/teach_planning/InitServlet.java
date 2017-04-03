package teach_planning;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import teach_planning.model.LoginModel;
import teach_planning.model.TeacherModel;
import teach_planning.model.TeachingModel;
import teach_planning.model.TypeAccount;
import teach_planning.service.LoginService;
import teach_planning.service.TeacherService;
import teach_planning.service.TeachingService;
import teach_planning.teaching.Teaching;

@WebServlet(name="InitServlet", loadOnStartup=1, urlPatterns={"/initLists"})
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
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
		ls.persist(new LoginModel("alexandre.afgoustidis@test.com", "default", TypeAccount.TEACHER));
		ls.persist(new LoginModel("stephane.airiau@test.com", "default", TypeAccount.TEACHER));
		ls.persist(new LoginModel("hassan.aissi@test.com", "default", TypeAccount.TEACHER));
		
		//Create the persistent teachers
		TeacherModel alex = new TeacherModel("Alexandre", "AFGOUSTIDIS", "alexandre.afgoustidis@test.com");
		TeacherModel steph = new TeacherModel("Stephane", "AIRIAU", "stephane.airiau@test.com");
		TeacherModel hassan = new TeacherModel("Hassan", "AISSI", "hassan.aissi@test.com");
		
		//Create the persistent teachings
		tgs.persist(new TeachingModel("Java", 20, 10, 15, 0, 2));
		tgs.persist(new TeachingModel("Communication", 10, 10, 0, 10, 1));
		tgs.persist(new TeachingModel("Analyse de données", 30, 0, 0, 5, 4));
		TeachingModel java = new TeachingModel("Java Objet", "CM","L3 INFO", 18,27);
		alex.getTeachings().add(java);
		java.getTeachers().add(alex);
		ts.persist(alex);
		TeachingModel alg = new TeachingModel("Algebre lineaire 2", "CM", "D.E.1", 19.5 ,29.25);
		steph.getTeachings().add(alg);
		alg.getTeachers().add(steph);
		TeachingModel projet= new TeachingModel("Projet Java", "CM","L3 INFO", 1.50,2.25);
		steph.getTeachings().add(projet);
		projet.getTeachers().add(steph);
		TeachingModel ia = new TeachingModel("Intelligence artificielle et raisonnement", "CM","M1 INFO", 18,27);
		steph.getTeachings().add(ia);
		ia.getTeachers().add(steph);
		ts.persist(steph);
		TeachingModel dec = new TeachingModel("Décision et analyse multicritere", "CM","M1 INFO", 18,27);
		hassan.getTeachings().add(dec);
		dec.getTeachers().add(hassan);
		ts.persist(hassan);
	}
	
}