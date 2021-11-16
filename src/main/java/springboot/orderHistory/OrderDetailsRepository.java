package springboot.orderHistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderItemBean, Integer> {

	@Query(value = "SELECT od.Quantity, od.Item_Type, od.Garbage_Start_Date, od.Garbage_End_Date "
			+ "FROM order_detail od WHERE od.fk_orderbean_orderno = ?1", nativeQuery = true)
	List<String[]> findByOrderId(int orderId);

	@Query(value = "SELECT od.fk_orderbean_orderno,od.Quantity, od.Item_Type, od.Garbage_Start_Date, od.Garbage_End_Date "
			+ "FROM order_detail od WHERE od.fk_orderbean_orderno = ?1", nativeQuery = true)
	List<String[]> appFindByOrderId(int orderId);
}
