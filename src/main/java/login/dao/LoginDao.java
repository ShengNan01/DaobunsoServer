package login.dao;

import register.model.MemberBean;

public interface LoginDao {
	
	String findPasswordByMemberAccount(String account);
	
	MemberBean findInfoByMemberAccount(String account);
}
