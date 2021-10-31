package orderHistory.dao;

import java.util.List;

import orderHistory.model.OrderBean;

public interface OrderDao {

	OrderBean findById(int Order_Id);

	List<OrderBean> findByMemberId(int memberId);

	List<Object[]> findInfoByMemberId(int memberId);
}