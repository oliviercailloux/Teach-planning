package io.github.oliviercailloux.teach_planning.teaching.bean;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import io.github.oliviercailloux.teach_planning.model.Assignment;
import io.github.oliviercailloux.teach_planning.model.Login;
import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.model.TypeAccount;
import io.github.oliviercailloux.teach_planning.service.AssignmentService;
import io.github.oliviercailloux.teach_planning.service.LoginService;
import io.github.oliviercailloux.teach_planning.service.TeacherService;
import io.github.oliviercailloux.teach_planning.service.TeachingService;

@ManagedBean
@RequestScoped
public class TeachingBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String teachingName;
	private String teachingType;
	private String cm;
	private String  tp;
	private String  td;
	private String  cmtd;
	private String  grp;
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private TeachingService teachingS;
	///
   
	public String getTeachingName(){
		return teachingName;
	}
	public String getTeachingType(){
		return teachingType;
	}
	public String  getCm() {
		return cm;
	}
	public String  getCmtd() {
		return cmtd;
	}
	public String  getGrp() {
		return grp;
	}
	
	public String  getTd() {
		return td;
	}
	public String  getTp() {
		return tp;
	}
	public void setCm(String  cm) {
		this.cm = cm;
	}
	public void setCmtd(String  cmtd) {
		this.cmtd = cmtd;
	}
	public void setGrp(String  grp) {
		this.grp = grp;
	}
	public void setTd(String  td) {
		this.td = td;
	}
	public void setTp(String  tp) {
		this.tp = tp;
	}
	public void setTeachingName(String teachingName) {
		this.teachingName = teachingName;
	}
	public void setTeachingType(String teachingType) {
		this.teachingType = teachingType;
	}
	
	public String saveTeaching(){
		int cmp =Integer.parseInt(cm);
		int tpp =Integer.parseInt(tp);
		int tdp =Integer.parseInt(td);
		int cmtdp =Integer.parseInt(cmtd);
		int grpp =Integer.parseInt(grp);
		String degree = "";
		if((cmp != 0 && (tpp != 0 || tdp !=0)) || cmtdp != 0){
			degree = "CMTD";
		}else if(cmp == 0 && (tpp != 0 || tdp !=0) && cmtdp == 0){
			degree = "TD";
		}else{
			degree = "CM";
		}	
		
		Teaching newTeaching = new Teaching(teachingName,teachingType, degree, cmp, tdp, tpp, cmtdp, grpp);
		teachingS.persist(newTeaching);
		return "teachingconfirmation.xhtml?faces-redirect=false";
    	//return "xhtml/addTeaching/teachingconfirmation.xhtml?faces-redirect=false";

	}
	

	
	// Creating a new teaching and stocking it on the list
		
		/// page d'affichage retour
		 
		/*try(PrintWriter pw=resp.getWriter()) {
		
			// Recapitulation of the new teaching added
			pw.println("<h2>Nouvel enseignement ajouté !</h2>");
			pw.println(newTeaching.toString() + "<br/>");
			
			// Proposition to add new teaching
			pw.println("<a href=\"jsps/addTeaching.jsp\">Ajouter un nouvel enseignement</a><br/>");
			pw.println("<a href=\"index.jsp\"> Retour à l'accueil </a>");
			
			// Recapitulation of all teaching stocked on the teaching list
			pw.println("<h1>Liste des enseignements</h1>");
			for(Teaching t : teachingS.getAll()) {
				pw.println(t.toString() + "<br/>");
			}	
		} catch(Exception e) {
			out.println("ERROR : " + e);
			Logger logger = Logger.getLogger(getClass().getName());
			logger.severe("Impossible to get writer from response in TeachingServlet \n "
					+ "The error is : " + e);
		}*/
	
	
}
