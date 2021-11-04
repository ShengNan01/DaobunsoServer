package commentAPP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import commentAPP.dao.CommentDao;
import commentAPP.model.CommentBean;
import commentAPP.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	private CommentDao commentDao;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	
	@Override
	@Transactional
	public void save(CommentBean commentBean) {
		
		commentDao.save(commentBean);
		
	}

}
