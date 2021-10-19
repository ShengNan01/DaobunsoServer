package login.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String account;
	private String password;
	
	
	public LoginBean() {
		super();
	}


	public LoginBean(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [account=" + account + ", password=" + password + "]";
	}
	
}
