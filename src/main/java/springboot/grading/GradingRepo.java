package springboot.grading;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@EnableJpaRepositories
@Repository
public interface GradingRepo extends JpaRepository<Grading,Integer> {
	@Query(nativeQuery = true,value=" SELECT MAX(Grading_id) FROM daobunso.grading ")
	Integer findLastid();

	List<Grading> findByAccount(String uaccount);
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value="UPDATE daobunso.grading SET Stars = :star ,Comment_Date = :date, Comment = :comment WHERE Grading_id= :objectid")
	void updateGradingById(@Param(value = "star")Integer star,@Param(value = "date")String date,@Param(value = "comment")String comment,@Param(value = "objectid")Integer objectid);
	
}
