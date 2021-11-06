package springboot.login;

import javax.persistence.Entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@ToString
//@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Login {
	@Getter
	@Setter
	private String account;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private Boolean rememberMe;
	
	

	
}
