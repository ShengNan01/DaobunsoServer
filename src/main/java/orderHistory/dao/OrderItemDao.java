package orderHistory.dao;

import java.util.List;

public interface OrderItemDao {
	
	List<Object[]> findByOrderId(int orderId);
}
