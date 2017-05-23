package io.github.oliviercailloux.teach_planning.model;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@Entity
@Table(name="LOGIN")
public class Login implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Basic(fetch=FetchType.EAGER, optional=false)
	private String login;
	@Basic(fetch=FetchType.LAZY, optional=false)
	private String password;
	@Enumerated(EnumType.STRING)
	private TypeAccount typeAccount;
	
	public Login() {
		
	}
	
	public Login(String login, String password) {
		this.login = login;
		this.password = password;
		this.typeAccount = TypeAccount.TEACHER;
	}
	
	public Login(String login, String password, TypeAccount typeAccount) {
		this.login = login;
		this.password = password;
		this.typeAccount = typeAccount;
	}

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
	
	public TypeAccount getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(TypeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}
	
	@Override
	public String toString() {
		return "Je suis l'utilisateur " + this.getLogin();
	}
	
	public void submitLoginPassword() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("connect");
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

}
