package orderHistory.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orderHistory.dao.OrderItemDao;
import orderHistory.model.OrderBean;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
	
	SessionFactory factory;

	@Autowired
	public OrderItemDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<OrderBean> findByOrderId(int orderId){
		List<OrderBean> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderBean ob WHERE ob.Order_Id = :orderId";
		list = session.createQuery(hql, OrderBean.class)
				  .setParameter("orderId", orderId)
				  .getResultList();
		return list;
	}

}
