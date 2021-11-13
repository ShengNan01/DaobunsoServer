package springboot.grading;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface GradingRepo extends JpaRepository<Grading,Integer> {
	@Query(nativeQuery = true,value=" SELECT MAX(Grading_id) FROM daobunso.grading;")
	Integer findLastid();

	List<Grading> findByAccount(String uaccount);
	
	@Query(nativeQuery = true,value="SELECT * FROM daobunso.grading WHERE Grading_id = :objectid")
	void updateGradingById(@Param(value = "objectid")Integer objectid);
	

}
