package springboot.orderHistory;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
// 本類別存放訂單資料

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_master") 
public class OrderBean {

	
	public OrderBean(Integer orderId, Date orderDate, Integer sum) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.sum = sum;
	}
	
	
	

	public OrderBean(Integer orderId, @NotBlank String contact, Integer sum) {
		super();
		this.orderId = orderId;
		this.contact = contact;
		this.sum = sum;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Order_Id")
	Integer orderId;

	@Column(name = "Order_Date")
	Date orderDate;

	@Column(name = "Member_Id")
	Integer memberId;

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
	String timeForGarbage;

	@Column(name = "Sum")
	Integer sum;

	@Column(name = "Pay_Type")
	String payType;

	@Column(name = "Tax_ID_number")
	String taxIDnumber;

	@Column(name = "Company_title")
	String companyTitle;

	@Column(name = "Schedule_Garbage")
	String scheduleGarbage;

//	@Transient
//	@OneToMany(mappedBy="orderBean")
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="fk_orderbean_orderno",referencedColumnName = "Order_Id")
	Set<OrderItemBean> items = new HashSet<>();
	 


	
//	@OneToMany(mappedBy="orderBean", cascade=CascadeType.ALL)
//	Set<OrderItemBean> items = new LinkedHashSet<>();
	
	
}
