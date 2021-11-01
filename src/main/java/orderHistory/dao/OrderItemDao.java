package orderHistory.dao;

import java.util.List;

import orderHistory.model.OrderBean;

public interface OrderItemDao {
	
	List<OrderBean> findByOrderId(int orderId);
}
