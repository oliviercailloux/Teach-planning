package teach_planning.model;

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

@Entity
@Table(name="LOGIN")
@SequenceGenerator(name="LOGIN_SEQUENCE", sequenceName="LOGIN_SEQ")
public class LoginModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOGIN_SEQUENCE")
	private int id;
	
	@Basic(fetch=FetchType.EAGER, optional=false)
	private static String login;
	@Basic(fetch=FetchType.LAZY, optional=false)
	private String password;
	@Enumerated(EnumType.STRING)
	private TypeAccount typeAccount;
	
	public LoginModel(String login, String password) {
		this.login = login;
		this.password = password;
		this.typeAccount = TypeAccount.TEACHER;
	}
	
	public LoginModel(String login, String password, TypeAccount typeAccount) {
		this.login = login;
		this.password = password;
		this.typeAccount = typeAccount;
	}

	public static String getLogin() {
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

}
