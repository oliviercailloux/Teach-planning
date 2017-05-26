package io.github.oliviercailloux.teach_planning;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import io.github.oliviercailloux.teach_planning.model.Assignment;
import io.github.oliviercailloux.teach_planning.model.Login;
import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.model.TypeAccount;
import io.github.oliviercailloux.teach_planning.service.AssignmentService;
import io.github.oliviercailloux.teach_planning.service.LoginService;
import io.github.oliviercailloux.teach_planning.service.TeacherService;
import io.github.oliviercailloux.teach_planning.service.TeachingService;

@WebServlet(name="InitServlet", loadOnStartup=1, urlPatterns={"/initLists"})
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	public LoginService ls;
	@Inject
	public TeacherService ts;
	@Inject
	public TeachingService tgs;
	@Inject
	public AssignmentService as;
	
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
		ts.persist(alex);
		Teacher steph = new Teacher("Stephane", "AIRIAU", "stephane.airiau@test.com");
		ts.persist(steph);
		Teacher hassan = new Teacher("Hassan", "AISSI", "hassan.aissi@test.com");
		ts.persist(hassan);
		
		//Create the persistent teachings
		tgs.persist(new Teaching("Java", "CM", "D.E.1",20, 10, 15, 0, 2));
		tgs.persist(new Teaching("Communication", "CM", "D.E.1",10, 10, 0, 10, 1));
		tgs.persist(new Teaching("Analyse de données", "CM", "D.E.1",30, 0, 0, 5, 4));
		Teaching java = new Teaching("Java Objet", "CM","L3 INFO", 18,27,0,0,0);
		tgs.persist(java);
		Teaching alg = new Teaching("Algebre lineaire 2", "CM", "D.E.1", 19.5 ,29.25,0,0,0);
		tgs.persist(alg);
		Teaching projet = new Teaching("Projet Java", "CM","L3 INFO", 1.50,2.25,0,0,0);
		tgs.persist(projet);
		Teaching ia = new Teaching("Intelligence artificielle et raisonnement", "CM","M1 INFO", 18,27,0,0,0);
		tgs.persist(ia);
		Teaching dec = new Teaching("Décision et analyse multicritere", "CM","M1 INFO", 18,27,0,0,0);
		tgs.persist(dec);
		
		//Create the persistent assignments
		as.persist(new Assignment(alex, java));
		as.persist(new Assignment(steph,alg));
		as.persist(new Assignment(steph,projet));
		as.persist(new Assignment(steph,ia));
		as.persist(new Assignment(hassan,dec));
	}
	
}