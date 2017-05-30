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
public class ResearchTeachingBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private String teachingName;
	private double cm;
	private double tp;
	private double td;
	private double cmtd;
	private double grp;
	
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private TeachingService teachingS;
	private List<Teaching> teachings;
	
	public String getTeachingName(){
		return teachingName;
	}
	
	public void setTeachingName(String teachingName) {
		this.teachingName = teachingName;
	}
	public double getCm() {
		return cm;
	}
	public void setCm(double cm) {
		this.cm = cm;
	}
	public double getCmtd() {
		return cmtd;
	}
	public double getGrp() {
		return grp;
	}
	public double getTd() {
		return td;
	}
	public double getTp() {
		return tp;
	}
	public void setCmtd(double cmtd) {
		this.cmtd = cmtd;
	}
	public void setGrp(double grp) {
		this.grp = grp;
	}
	public void setTd(double td) {
		this.td = td;
	}
	public void setTp(double tp) {
		this.tp = tp;
	}
		
	private Teaching teaching;

	
	@PostConstruct
	public void init(){
		
		for(Teaching t : teachingS.getAll()) {
			if(t.getName().equals(this.teachingName))
				this.teaching = t;
		}
	}
	
	public String researchTeaching(){
		teachings=teachingS.getAll();
		int k = teachings.size();
		for(int i=0;i<k;i++){
			Teaching myteaching= teachings.get(i);
			String myteachingname = myteaching.getName();
		
			if(myteachingname.equals(teachingName)){
				cm=myteaching.getNbCM();
				td=myteaching.getNbTD();
				tp=myteaching.getNbTP();
				cmtd=myteaching.getNbCMTD();
				grp=myteaching.getNbGrp();
				return "researchTeachingConfirmation.xhtml?faces-redirect=false";
			}
		}
		return "researchTeachingFailed.xhtml?faces-redirect=false";

	}
}	