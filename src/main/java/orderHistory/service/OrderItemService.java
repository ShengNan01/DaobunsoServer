package orderHistory.service;

import java.util.List;

import orderHistory.model.OrderItemBean;

public interface OrderItemService {
	
	List<OrderItemBean> findByOrderId(int orderId);

}
