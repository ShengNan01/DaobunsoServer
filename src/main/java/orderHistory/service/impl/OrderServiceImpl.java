package orderHistory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orderHistory.dao.OrderDao;
import orderHistory.model.OrderBean;
import orderHistory.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;

	@Autowired
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	@Transactional
	public OrderBean findById(int Order_Id) {
		OrderBean  bean = null;
//      Session session = factory.getCurrentSession();
//      Transaction tx = null;
//      try {
//          tx = session.beginTransaction();
          bean = orderDao.findById(Order_Id);
//          tx.commit();
//      } catch (Exception e) {
//          if (tx != null) tx.rollback();
//          throw new RuntimeException(e);
//      } 
		return bean;
	}

	@Override
	@Transactional
	public List<OrderBean> findByMemberId(int memberId) {
//		Session session = factory.getCurrentSession();
		List<OrderBean> list = null;
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
            list = orderDao.findByMemberId(memberId);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            throw new RuntimeException(e);
//        } 
        return list;	
	}

	@Override
	@Transactional
	public List<Object[]> findInfoByMemberId(int memberId) {
		List<Object[]> list = null;
		list = orderDao.findInfoByMemberId(memberId);
		return list;
	}	

}
