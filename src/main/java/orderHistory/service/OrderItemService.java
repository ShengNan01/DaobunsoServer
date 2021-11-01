package orderHistory.service;

import java.util.List;

import orderHistory.model.OrderBean;

public interface OrderItemService {
	
	List<OrderBean> findByOrderId(int orderId);

}
