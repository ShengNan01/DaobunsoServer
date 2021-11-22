package springboot.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	@Autowired
	ProductRepo productRepo;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		products = productRepo.findAll();
		return products;
	}
	
	@GetMapping("/productd")
	public Optional<Product> getP(@RequestParam Integer id) {
		System.out.println(productRepo.findById(id));
		return productRepo.findById(id);
	}
	
}
