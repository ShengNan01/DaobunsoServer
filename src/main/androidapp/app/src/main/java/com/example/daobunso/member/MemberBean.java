package com.example.daobunso.member;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberBean implements Serializable {

	private static final long serialVersionUID = 1L;
	Integer pkey;
	String Account;
	String Email;
	String Password;
	String Member_name;
	Timestamp Join_Date;

	public MemberBean(Integer pkey, String account, String email, String password, String member_name,
			Timestamp join_Date) {
		this.pkey = pkey;
		this.Account = account;
		this.Email = email;
		this.Password = password;
		this.Member_name = member_name;
		this.Join_Date = join_Date;
	}
	public MemberBean() {
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
	public Integer getPkey() {
		return pkey;
	}
	public void setPkey(Integer pkey) {
		this.pkey = pkey;
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
	@Override
	public String toString() {
		return "MemberBean [Account=" + Account + ", Email=" + Email + ", Password=" + Password + ", Member_name="
				+ Member_name + ", Join_Date=" + Join_Date + "]";
	}
}
