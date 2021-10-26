package register.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "member")
public class MemberBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Member_Id;
	String Email;
	String Account;
	String Password;
	String Member_name;
	Timestamp Join_Date;

	public MemberBean() {
		super();
	}

	public MemberBean(Integer member_Id, String email, String account, String password, String member_name,
			Timestamp join_Date) {
		super();
		Member_Id = member_Id;
		Email = email;
		Account = account;
		Password = password;
		Member_name = member_name;
		Join_Date = join_Date;
	}

	public Integer getMemberId() {
		return Member_Id;
	}

	public void setMemberId(Integer memberId) {
		this.Member_Id = memberId;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMember_name() {
		return Member_name;
	}

	public void setMember_name(String member_name) {
		Member_name = member_name;
	}

	public Timestamp getJoin_Date() {
		return Join_Date;
	}

	public void setJoin_Date(Timestamp join_Date) {
		Join_Date = join_Date;
	}

}
