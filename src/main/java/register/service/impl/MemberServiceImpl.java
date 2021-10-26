package register.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import register.dao.MemberDao;
import register.model.MemberBean;
import register.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	MemberDao memberDao;
	
//	public MemberServiceImpl() {
//		this.factory = HibernateUtils.getSessionFactory();
//		memberDao = new MemberDaoImpl();	
//	}
	@Autowired
	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Transactional
	@Override
	public boolean existsByMemberAccount(String account) {
		boolean exists = false;
			exists = memberDao.existsByMemberAccount(account);
		return exists;
	}

	@Transactional
	@Override
	public void save(MemberBean memberBean) {
			memberDao.save(memberBean);
	}

	@Transactional
	@Override
	public List<MemberBean> findAll() {
		List<MemberBean> beans = null;
			beans = memberDao.findAll();
		return beans;
	}

	@Transactional
	@Override
	public MemberBean findById(Integer memberId) {
		MemberBean memberBean = null;
			memberBean = memberDao.findById(memberId);
		return memberBean;
	}

	@Transactional
	@Override
	public void delete(Integer memberId) {
			memberDao.delete(memberId);
	}

	@Transactional
	@Override
	public void update(MemberBean memberBean) {
			memberDao.update(memberBean);
	}
	@Transactional
	@Override
	public boolean existsByMemberEmail(String email) {
		boolean exists = false;
		exists = memberDao.existsByMemberEmail(email);
		return exists;
	}

}
