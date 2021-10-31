package orderHistory.dao;

import java.util.List;

import orderHistory.model.OrderItemBean;

public interface OrderItemDao {
	
	List<OrderItemBean> findByOrderId(int orderId);
}
