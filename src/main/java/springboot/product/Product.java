package springboot.product;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId")
	private Integer id;

	@Column(name = "ProductName")
	private String name;

	@Column(name = "ProductImage")
	private String imagepath;

	@Column(name = "Inventory")
	private Integer inventory;

	@Column(name = "SalePrice")
	private Integer price;

	@Column(name = "ProductContent")
	private String content;

}
