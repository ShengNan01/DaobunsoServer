package orderHistory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orderHistory.dao.OrderItemDao;
import orderHistory.model.OrderItemBean;
import orderHistory.service.OrderItemService;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemDao orderItemDao;
	
	@Override
	public List<OrderItemBean> findByOrderId(int orderId) {
		List<OrderItemBean> list = null;
		list = orderItemDao.findByOrderId(orderId);
		return list;
	}

}
