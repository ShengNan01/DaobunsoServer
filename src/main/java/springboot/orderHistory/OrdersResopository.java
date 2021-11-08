package springboot.orderHistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersResopository extends JpaRepository<OrderBean, Integer> {
	
	@Query(value = "SELECT om.Order_Id, om.Order_Date, om.Sum "
			+ "FROM order_master om WHERE om.Member_Id = ?1",nativeQuery = true)
	List<Object[]> findInfoByMemberId(int memberId);

}
