package loginPackage;

@administrator
public class LoginAdmin extends Login{

	public LoginAdmin(String login, String password) {
		super(login, password);
	}
	
	@Override
	public String toString() {
		return "Je suis l'administrateur " + this.getLogin();
	}

}
