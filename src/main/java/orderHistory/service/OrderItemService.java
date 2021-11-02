package orderHistory.service;

import java.util.List;

public interface OrderItemService {
	
	public List<Object[]> findByOrderId(int orderId);

}
