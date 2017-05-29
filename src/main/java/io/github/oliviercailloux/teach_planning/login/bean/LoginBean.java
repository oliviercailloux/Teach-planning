package io.github.oliviercailloux.teach_planning.login.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import io.github.oliviercailloux.teach_planning.model.Login;
import io.github.oliviercailloux.teach_planning.service.LoginService;

@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {

	@Inject
	private LoginService ls;
	
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String submitLoginPassword() {
		String result = ls.isExistLoginPassword(this.getLogin(), this.getPassword());
		
		if(result=="OK") {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogin",this.getLogin());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("errorLogin");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("errorLogin",result);
		}
		
		return "login.xhtml?faces-redirect=true";
	}
	
	public String disconnect() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("userLogin");
		return "login.xhtml?faces-redirect=true";
	}
}
