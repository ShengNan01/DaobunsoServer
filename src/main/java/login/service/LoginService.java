package login.service;

import register.model.MemberBean;

public interface LoginService {
	boolean existsByMemberAccount(String account);
	
	String findPasswordByMemberAccount(String account);
	
	MemberBean findInfoByMemberAccount(String account);
	
}
