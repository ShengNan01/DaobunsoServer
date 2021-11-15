package springboot.orderHistory;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//本類別封裝單筆訂單資料 (訂購紀錄點編號(order_master)(對應老師範例orders) > 訂單明細（order_details）(對應老師範例orderItem) >)

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderItemBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Order_detail_no")
	Integer order_detail_no;
	
	@Column(name = "Quantity")
	Integer quantity;
	
	@Column(name = "Item_Type")
	String item_Type;
	
	@Column(name = "garbage_Start_Date")
	Date garbage_Start_Date;
	
	@Column(name = "Garbage_End_Date")
	Date garbage_End_Date;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_orderbean_orderno")
	OrderBean orderBean;
	

}