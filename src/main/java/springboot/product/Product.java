package springboot.product;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

// @Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_Id")
	private Integer id;

	@Column(name = "Product_Name")
	private String name;

	@Column(name = "Product_Image")
	private String imagepath;
	
	@Column(name = "Inventory")
	private Integer inventory;

	@Column(name = "Sale_Price")
	private Integer price;
	
	@Column(name = "Product_Content")
	private String content;

}
