package springboot.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import springboot.payment.entity.user;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<user, Integer> {

}
