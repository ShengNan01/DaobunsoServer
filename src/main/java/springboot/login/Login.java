package springboot.login;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@ToString
//@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Login {
	private String account;
	private String password;
	private Boolean rememberMe;
	
	
	public Login() {
		super();
	}
	public Login(String account, String password, Boolean rememberMe) {
		super();
		this.account = account;
		this.password = password;
		this.rememberMe = rememberMe;
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
	public Boolean getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	
}
