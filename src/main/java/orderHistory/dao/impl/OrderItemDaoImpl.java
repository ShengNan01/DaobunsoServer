package orderHistory.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orderHistory.dao.OrderItemDao;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
	
	SessionFactory factory;

	@Autowired
	public OrderItemDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findByOrderId(int orderId){
		List<Object[]> list = null;
		Session session = factory.getCurrentSession();
		String hql = "SELECT oib.Quantity, oib.Item_Type, oib.Garbage_Start_Date, oib.Garbage_End_Date "
				+ "FROM OrderItemBean oib WHERE oib.orderBean.Order_Id = :orderId";
		list = session.createQuery(hql)
				  .setParameter("orderId", orderId)
				  .getResultList();
		return list;
	}

}
