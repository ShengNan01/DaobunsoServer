package login.model;

import java.io.Serializable;

public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String account;
	private String password;
	private boolean rememberMe;
	
	
	public LoginBean() {
		super();
	}


	public LoginBean(String account, String password,Boolean rememberMe) {
		super();
		this.account = account;
		this.password = password;
		this.rememberMe = rememberMe;
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
	
	

	public boolean getRememberMe() {
		return rememberMe;
	}


	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}


	@Override
	public String toString() {
		return "LoginBean [account=" + account + ", password=" + password + ", rememberMe=" + rememberMe + "]";
	}
	
	


	
}
