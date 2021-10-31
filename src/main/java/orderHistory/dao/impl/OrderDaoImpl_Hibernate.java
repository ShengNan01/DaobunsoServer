package orderHistory.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orderHistory.dao.OrderDao;
import orderHistory.model.OrderBean;

// 本類別
//   1.查詢orders表格內的單筆訂單
//   2.查詢orders表格內的所有訂單

@Repository
public class OrderDaoImpl_Hibernate implements OrderDao {

	SessionFactory factory;
	
	int Order_Id = 0;

	@Autowired
	public OrderDaoImpl_Hibernate(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public OrderBean findById(int Order_Id) {
		OrderBean ob = null;
		Session session = factory.getCurrentSession();
		ob = session.get(OrderBean.class, Order_Id);
		return ob;
	}

	@Override
	public List<OrderBean> findByMemberId(int memberId) {
		List<OrderBean> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderBean ob WHERE ob.Member_Id = :mid";
		list = session.createQuery(hql, OrderBean.class)
					  .setParameter("mid", memberId)
					  .getResultList();
	
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findInfoByMemberId(int memberId) {
		List<Object[]> list = null;
		Session session = factory.getCurrentSession();
		String sql = "SELECT om.Order_Id, om.Order_Date, om.Sum FROM order_master om WHERE om.Member_Id = :mid";
		list = session.createNativeQuery(sql)
					  .setParameter("mid", memberId)
					  .getResultList();
		return list;
		
	}

}