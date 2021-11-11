package springboot.orderHistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface OrdersResopository extends JpaRepository<OrderBean,Integer> {
	
	@Query(value = "SELECT om.Order_Id, date_format(om.Order_Date,'%Y-%c-%d %H:%i:%s'), om.Sum "
			+ "FROM order_master om WHERE om.Member_Id = ?1",nativeQuery = true)
	List<String[]> findInfoByMemberId(Integer memberId);
	
	
	@Query(value = "SELECT FROM order_master om WHERE om.Account = :account",nativeQuery = true)
	List<OrderBean> findInfoByAccount(String account);


}
