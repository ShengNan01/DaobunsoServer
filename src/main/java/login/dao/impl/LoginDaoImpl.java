package login.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import login.dao.LoginDao;
import register.model.MemberBean;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	SessionFactory factory;

	@Autowired
	public LoginDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	// 由使用者輸入的account找password
	@Override
	public String findPasswordByMemberAccount(String account) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean m WHERE m.Account = :account";
		MemberBean bean = session.createQuery(hql, MemberBean.class)
                .setParameter("account", account)
                .getSingleResult();
		
		return bean.getPassword();
	}

	@Override
	public MemberBean findInfoByMemberAccount(String account) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean m WHERE m.Account = :account";
		MemberBean bean = session.createQuery(hql, MemberBean.class)
                .setParameter("account", account)
                .getSingleResult();
		return bean;
	}
}
