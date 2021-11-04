package commentAPP.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import commentAPP.dao.CommentDao;
import commentAPP.model.CommentBean;


@Repository
public class CommentDaoImpl implements CommentDao{

	
	SessionFactory factory;
	
	
	@Autowired
	public CommentDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public void save(CommentBean commentBean) {
		Session session = factory.getCurrentSession();
		session.save(commentBean);

	}
	
}
