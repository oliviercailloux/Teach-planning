package teach_planning;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import teach_planning.model.Login;
import teach_planning.model.Teacher;
import teach_planning.model.Teaching;
import teach_planning.model.TypeAccount;
import teach_planning.service.LoginService;
import teach_planning.service.TeacherService;
import teach_planning.service.TeachingService;

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
		ls.persist(new Login("cathy.marques@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new Login("mathilde.masson@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new Login("alessandro.quaresima@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new Login("amelie.quach@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new Login("abdoulaye.diarra@test.com", "root", TypeAccount.ADMINISTRATOR));
		ls.persist(new Login("sandratra.razafiniaina@test.com", "root", TypeAccount.ADMINISTRATOR));
		//Create the persistent logins for teachers
		ls.persist(new Login("alexandre.afgoustidis@test.com", "default", TypeAccount.TEACHER));
		ls.persist(new Login("stephane.airiau@test.com", "default", TypeAccount.TEACHER));
		ls.persist(new Login("hassan.aissi@test.com", "default", TypeAccount.TEACHER));
		
		//Create the persistent teachers
		Teacher alex = new Teacher("Alexandre", "AFGOUSTIDIS", "alexandre.afgoustidis@test.com");
		Teacher steph = new Teacher("Stephane", "AIRIAU", "stephane.airiau@test.com");
		Teacher hassan = new Teacher("Hassan", "AISSI", "hassan.aissi@test.com");
		
		//Create the persistent teachings
		tgs.persist(new Teaching("Java", 20, 10, 15, 0, 2));
		tgs.persist(new Teaching("Communication", 10, 10, 0, 10, 1));
		tgs.persist(new Teaching("Analyse de données", 30, 0, 0, 5, 4));
		Teaching java = new Teaching("Java Objet", "CM","L3 INFO", 18,27);
		alex.getTeachings().add(java);
		java.getTeachers().add(alex);
		ts.persist(alex);
		Teaching alg = new Teaching("Algebre lineaire 2", "CM", "D.E.1", 19.5 ,29.25);
		steph.getTeachings().add(alg);
		alg.getTeachers().add(steph);
		Teaching projet= new Teaching("Projet Java", "CM","L3 INFO", 1.50,2.25);
		steph.getTeachings().add(projet);
		projet.getTeachers().add(steph);
		Teaching ia = new Teaching("Intelligence artificielle et raisonnement", "CM","M1 INFO", 18,27);
		steph.getTeachings().add(ia);
		ia.getTeachers().add(steph);
		ts.persist(steph);
		Teaching dec = new Teaching("Décision et analyse multicritere", "CM","M1 INFO", 18,27);
		hassan.getTeachings().add(dec);
		dec.getTeachers().add(hassan);
		ts.persist(hassan);
	}
	
}