package springboot.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
