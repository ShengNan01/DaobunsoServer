package orderHistory.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orderHistory.dao.OrderItemDao;
import orderHistory.model.OrderItemBean;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
	
	SessionFactory factory;

	@Autowired
	public OrderItemDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<OrderItemBean> findByOrderId(int orderId) {
		List<OrderItemBean> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderItemBean oib WHERE oib.orderBean.Order_Id = :orderId";
		list = session.createQuery(hql, OrderItemBean.class)
					  .setParameter("oid", orderId)
					  .getResultList();
		return list;
	}

}
