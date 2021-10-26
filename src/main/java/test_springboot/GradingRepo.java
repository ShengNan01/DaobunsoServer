package test_springboot;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//@EnableJpaRepositories
@Repository
public interface GradingRepo extends JpaRepository<Grading,Integer> {

	List<Grading> findByAccount(String uaccount);
	
	List<Grading> findByStar(Integer star);
	
	List<Grading> findByComment(String comment);
}
