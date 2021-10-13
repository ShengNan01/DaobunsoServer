package register.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import register.dao.MemberDao;
import register.dao.impl.MemberDaoImpl;
import register.model.MemberBean;
import register.service.MemberService;
import util.HibernateUtils;

public class MemberServiceImpl implements MemberService {
	SessionFactory factory;
	MemberDao memberDao;
	
	public MemberServiceImpl() {
		this.factory = HibernateUtils.getSessionFactory();
		memberDao = new MemberDaoImpl();	
	}

	@Override
	public boolean existsByMemberAccount(String account) {
		boolean exists = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			exists = memberDao.existsByMemberAccount(account);
			tx.commit();
		}catch(Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return exists;
	}

	@Override
	public void save(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.save(memberBean);
			tx.commit();
		}catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> findAll() {
		List<MemberBean> beans = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			beans = memberDao.findAll();
			tx.commit();
		}catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return beans;
	}

	@Override
	public MemberBean findById(Integer memberId) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		MemberBean memberBean = null;
		try {
			tx = session.beginTransaction();
			memberBean = memberDao.findById(memberId);
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return memberBean;
	}

	@Override
	public void delete(Integer memberId) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.delete(memberId);
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void update(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.update(memberBean);
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

}
