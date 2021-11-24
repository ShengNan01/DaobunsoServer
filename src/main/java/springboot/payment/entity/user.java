package springboot.payment.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import springboot.orderHistory.OrderItemBean;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "order_master")

public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Order_Id")
	private int orderId;

//    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Order_Date")
	private Timestamp orderDate;

	@Column(name = "Member_Id")
	private int memberId;

	@Column(name = "Address")
	private String address;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Contact")
	private String contact;

	@Column(name = "Time_For_Garbage")
	private String timeForGarbage;

	@Column(name = "Sum")
	private String sum;

	@Column(name = "Pay_Type")
	private String payType;

	@Column(name = "Tax_ID_number")
	private String taxIDnumber;

	@Column(name = "Company_title")
	private String companytitle;

	@Column(name = "Schedule_Garbage")
	private String scheduleGarbage;
	
	@Transient
	@Column(name = "PayPayment")
	private String payPayment;
	
	@Column(name = "DetailNo")
	private String detailNo;
	
	@Column(name= "PaymentStatus")
	private String paymentStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_orderbean_orderno", referencedColumnName = "Order_Id")
	private List<userDetail> userDetails;


//	public int getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//	public Date getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}
//
//	public int getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(int memberId) {
//		this.memberId = memberId;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getContact() {
//		return contact;
//	}
//
//	public void setContact(String contact) {
//		this.contact = contact;
//	}
//
//	public String getTimeForGarbage() {
//		return timeForGarbage;
//	}
//
//	public void setTimeForGarbage(String timeForGarbage) {
//		this.timeForGarbage = timeForGarbage;
//	}
//
//	public int getSum() {
//		return sum;
//	}
//
//	public void setSum(int sum) {
//		this.sum = sum;
//	}
//
//	public String getPayType() {
//		return payType;
//	}
//
//	public void setPayType(String payType) {
//		this.payType = payType;
//	}
//
//	public String getTaxIDnumber() {
//		return taxIDnumber;
//	}
//
//	public void setTaxIDnumber(String taxIDnumber) {
//		this.taxIDnumber = taxIDnumber;
//	}
//
//	public String getCompanytitle() {
//		return companytitle;
//	}
//
//	public void setCompanytitle(String companytitle) {
//		this.companytitle = companytitle;
//	}
//
//	public String getScheduleGarbage() {
//		return scheduleGarbage;
//	}
//
//	public void setScheduleGarbage(String scheduleGarbage) {
//		this.scheduleGarbage = scheduleGarbage;
//	}

}
