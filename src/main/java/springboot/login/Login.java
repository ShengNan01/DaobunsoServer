package springboot.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Component
@ToString
@Data
@Getter
@Setter
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
	@Transient
	private Boolean rememberMe;

	
}
