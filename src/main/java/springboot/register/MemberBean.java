package springboot.register;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "member")
public class MemberBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Member_Id")
	Integer memberId;

	@NotBlank
	@Column(name = "Email")
	String email;

	@NotBlank
	@Column(name = "Account")
	String account;

	@NotBlank
	@Column(name = "Password")
	String password;

	@NotBlank
	@Column(name = "Member_name")
	String member_name;

	@Column(name = "Join_Date")
	Timestamp join_Date;

	@Transient
	@Column(name = "NewPassword")
	String newPassword;
	@Transient
	@Column(name = "verification")
	private Integer verification;
//	public String getNewPassword() {
//		return NewPassword;
//	}
//
//	public void setNewPassword(String newPassword) {
//		NewPassword = newPassword;
//	}
//
//	public MemberBean() {
//		super();
//	}
//
//	public Integer getMember_Id() {
//		return member_Id;
//	}
//
//	public void setMember_Id(Integer member_Id) {
//		this.member_Id = member_Id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getAccount() {
//		return account;
//	}
//
//	public void setAccount(String account) {
//		this.account = account;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getMember_name() {
//		return member_name;
//	}
//
//	public void setMember_name(String member_name) {
//		this.member_name = member_name;
//	}
//
//	public Timestamp getJoin_Date() {
//		return join_Date;
//	}
//
//	public void setJoin_Date(Timestamp join_Date) {
//		this.join_Date = join_Date;
//	}
//
//	public MemberBean(Integer member_Id, @NotBlank String email, @NotBlank String account, @NotBlank String password,
//			@NotBlank String member_name, Timestamp join_Date) {
//		super();
//		this.member_Id = member_Id;
//		this.email = email;
//		this.account = account;
//		this.password = password;
//		this.member_name = member_name;
//		this.join_Date = join_Date;
//	}

}
