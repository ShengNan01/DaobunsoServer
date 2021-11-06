package springboot.login;

import javax.persistence.*;

import lombok.*;
import org.springframework.stereotype.Component;

//@Component
//@Getter
//@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Member_Id")
	private Integer id;

	@Column(name="Member_name")
	private String name;

	@Column(name="Email")
	private String email;

	@Column(name="Account")
	private String account;

	@Column(name="Password")
	private String password;

	private Boolean rememberMe;

}
