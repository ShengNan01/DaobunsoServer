package orderHistory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orderHistory.dao.OrderItemDao;
import orderHistory.service.OrderItemService;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemDao orderItemDao;
	
	@Autowired
	public OrderItemServiceImpl(OrderItemDao orderItemDao) {
		super();
		this.orderItemDao = orderItemDao;
	}

	@Override
	public List<Object[]> findByOrderId(int orderId){
		List<Object[]> list = null;
		list = orderItemDao.findByOrderId(orderId);
		return list;
	}

}
