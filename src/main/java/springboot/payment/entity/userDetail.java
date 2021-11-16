package springboot.payment.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="order_detail")
public class userDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_detail_no")
    private int orderdetailno;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Item_Type")
    private String itemType;

    @Column(name = "Garbage_Start_Date")
    private Date garbageStartDate;

    @Column(name = "Garbage_End_Date")
    private Date garbageEndDate;




//    @ManyToOne(cascade = CascadeType.PERSIST)
////    @JoinColumn(name="fk_OrderBean_orderno",referencedColumnName = "Order_Id")
//    user user;












}
