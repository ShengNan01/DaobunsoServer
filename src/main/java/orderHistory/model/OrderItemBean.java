package orderHistory.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//本類別封裝單筆訂單資料 (訂購紀錄點編號(order_master)(對應老師範例orders) > 訂單明細（order_details）(對應老師範例orderItem) >)
@Entity
@Table(name = "order_detail")
public class OrderItemBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Order_detail_no;
	Integer Quantity;
	String Item_Type;
	Date Garbage_Start_Date;
	Date Garbage_End_Date;
	
	@ManyToOne
	@JoinColumn(name = "FK_OrderBean_orderNo")
	OrderBean orderBean;
	
	public OrderItemBean() {
	}

	public OrderItemBean(Integer order_detail_no, Integer quantity, String item_Type, Date garbage_Start_Date,
			Date garbage_End_Date, OrderBean orderBean) {
		super();
		Order_detail_no = order_detail_no;
		Quantity = quantity;
		Item_Type = item_Type;
		Garbage_Start_Date = garbage_Start_Date;
		Garbage_End_Date = garbage_End_Date;
		this.orderBean = orderBean;
	}

	public Integer getOrder_detail_no() {
		return Order_detail_no;
	}

	public void setOrder_detail_no(Integer order_detail_no) {
		Order_detail_no = order_detail_no;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public String getItem_Type() {
		return Item_Type;
	}

	public void setItem_Type(String item_Type) {
		Item_Type = item_Type;
	}

	public Date getGarbage_Start_Date() {
		return Garbage_Start_Date;
	}

	public void setGarbage_Start_Date(Date garbage_Start_Date) {
		Garbage_Start_Date = garbage_Start_Date;
	}

	public Date getGarbage_End_Date() {
		return Garbage_End_Date;
	}

	public void setGarbage_End_Date(Date garbage_End_Date) {
		Garbage_End_Date = garbage_End_Date;
	}

	public OrderBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

}