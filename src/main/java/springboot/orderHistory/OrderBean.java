package springboot.orderHistory;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
// 本類別存放訂單資料

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_master") 
public class OrderBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Order_Id")
	Integer order_Id;

	@Column(name = "Order_Date")
	Timestamp order_Date;

	@Column(name = "Member_Id")
	Integer member_Id;

	@NotBlank
	@Column(name = "Address")
	String address;

	@NotBlank
	@Column(name = "Phone")
	String phone;

	@NotBlank
	@Column(name = "Contact")
	String contact;

	@Column(name = "Time_For_Garbage")
	String time_For_Garbage;

	@Column(name = "Sum")
	Integer sum;

	@Column(name = "Pay_Type")
	String pay_Type;

	@Column(name = "Tax_ID_number")
	String tax_ID_number;

	@Column(name = "Company_title")
	String company_title;

	@Column(name = "Schedule_Garbage")
	String schedule_Garbage;

	@Transient
	@OneToMany(mappedBy="orderBean")
	Set<OrderItemBean> items = new HashSet<>();

	
//	@OneToMany(mappedBy="orderBean", cascade=CascadeType.ALL)
//	Set<OrderItemBean> items = new LinkedHashSet<>();
	
	
}
