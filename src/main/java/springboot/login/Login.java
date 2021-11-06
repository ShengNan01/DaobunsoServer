package springboot.login;

import javax.persistence.*;

import lombok.*;
import org.springframework.stereotype.Component;

//@Component
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member")
public class Login {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Member_Id")
	private Integer id;

	@Getter
	@Setter
	@Column(name="Member_name")
	private String name;

	@Getter
	@Setter
	@Column(name="Email")
	private String email;

	@Getter
	@Setter
	@Column(name="Account")
	private String account;

	@Getter
	@Setter
	@Column(name="Password")
	private String password;

	@Getter
	@Setter
	private Boolean rememberMe;

}
