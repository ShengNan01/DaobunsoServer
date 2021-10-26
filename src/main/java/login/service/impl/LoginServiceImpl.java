package login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import login.dao.LoginDao;
import login.service.LoginService;
import register.dao.MemberDao;
import register.model.MemberBean;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	MemberDao memberDao;
	LoginDao loginDao;

	@Autowired
	public LoginServiceImpl(MemberDao memberDao, LoginDao loginDao) {
		this.memberDao = memberDao;
		this.loginDao = loginDao;
	}

	@Override
	public boolean existsByMemberAccount(String account) {
			
		return memberDao.existsByMemberAccount(account);
		
	}

	@Override
	public String findPasswordByMemberAccount(String account) {
		String password = null;
		password = loginDao.findPasswordByMemberAccount(account);
		return password;
	}

	@Override
	public MemberBean findInfoByMemberAccount(String account) {
		MemberBean member = null;
		member = loginDao.findInfoByMemberAccount(account);
		return member;
	}
}
