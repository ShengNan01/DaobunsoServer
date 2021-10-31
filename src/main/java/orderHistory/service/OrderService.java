package orderHistory.service;

import java.util.List;

import orderHistory.model.OrderBean;

// 本介面處理訂單。一張訂單的所有資訊是存放在OrderBean內，而訂單明細是存放在  
// Set<OrderItemBean> items 屬性內。
// 
// 此介面提供訂單查詢的功能，依照訂單編號來查詢單筆訂單
//
// 實作此介面的類別為 orderHistory.service.impl.OrderServiceImpl
// 
public interface OrderService {
	
	OrderBean findById(int orderId);

	List<OrderBean> findByMemberId(int memberId);
	
	List<Object[]> findInfoByMemberId(int memberId);

}
