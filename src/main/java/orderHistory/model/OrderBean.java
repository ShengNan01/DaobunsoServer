package orderHistory.model;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// 本類別存放訂單資料
@Entity
@Table(name="order_master") 
public class OrderBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer Order_Id;
	Timestamp Order_Date;
	Integer Member_Id;
	String Address;
	String Phone;
	String Contact;
	String Time_For_Garbage;
	Integer Sum;
	String Pay_Type;
	String Tax_ID_number;
	String Company_title;	
	String Schedule_Garbage;
	
	@OneToMany(mappedBy="orderBean", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	Set<OrderItemBean> items = new LinkedHashSet<>();

	public OrderBean() {
	}

	public OrderBean(Integer order_Id, Timestamp order_Date, Integer member_Id, String address, String phone,
			String contact, String time_For_Garbage, Integer sum, String pay_Type, String tax_ID_number,
			String company_title, String schedule_Garbage, Set<OrderItemBean> items) {
		super();
		Order_Id = order_Id;
		Order_Date = order_Date;
		Member_Id = member_Id;
		Address = address;
		Phone = phone;
		Contact = contact;
		Time_For_Garbage = time_For_Garbage;
		Sum = sum;
		Pay_Type = pay_Type;
		Tax_ID_number = tax_ID_number;
		Company_title = company_title;
		Schedule_Garbage = schedule_Garbage;
		this.items = items;
	}

	public Integer getOrder_Id() {
		return Order_Id;
	}

	public void setOrder_Id(Integer order_Id) {
		Order_Id = order_Id;
	}

	public Timestamp getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(Timestamp order_Date) {
		Order_Date = order_Date;
	}

	public Integer getMember_Id() {
		return Member_Id;
	}

	public void setMember_Id(Integer member_Id) {
		Member_Id = member_Id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getTime_For_Garbage() {
		return Time_For_Garbage;
	}

	public void setTime_For_Garbage(String time_For_Garbage) {
		Time_For_Garbage = time_For_Garbage;
	}

	public Integer getSum() {
		return Sum;
	}

	public void setSum(Integer sum) {
		Sum = sum;
	}

	public String getPay_Type() {
		return Pay_Type;
	}

	public void setPay_Type(String pay_Type) {
		Pay_Type = pay_Type;
	}

	public String getTax_ID_number() {
		return Tax_ID_number;
	}

	public void setTax_ID_number(String tax_ID_number) {
		Tax_ID_number = tax_ID_number;
	}

	public String getCompany_title() {
		return Company_title;
	}

	public void setCompany_title(String company_title) {
		Company_title = company_title;
	}

	public String getSchedule_Garbage() {
		return Schedule_Garbage;
	}

	public void setSchedule_Garbage(String schedule_Garbage) {
		Schedule_Garbage = schedule_Garbage;
	}

	public Set<OrderItemBean> getItems() {
		return items;
	}

	public void setItems(Set<OrderItemBean> items) {
		this.items = items;
	}
	
	

	
//	@OneToMany(mappedBy="orderBean", cascade=CascadeType.ALL)
//	Set<OrderItemBean> items = new LinkedHashSet<>();
	
	
}
