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

	
}
