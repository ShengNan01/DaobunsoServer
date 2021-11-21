package springboot.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	@Autowired
	ProductRepo productRepo;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		products = productRepo.findAll();
		System.out.println(products);
		return products;
	}
}
