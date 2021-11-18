package springboot.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import springboot.payment.entity.userDetail;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends JpaRepository<userDetail, Integer> {
}
