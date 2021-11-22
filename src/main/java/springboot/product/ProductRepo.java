package springboot.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import springboot.grading.Grading;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
