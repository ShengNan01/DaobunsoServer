package test_springboot;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Component
//@ConfigurationProperties(prefix = "feedback")
@ToString
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="grading")
public class Grading {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Grading_id")
	private Integer objectid;

	@Column(name = "Account")
	private String user_account;
	
	@Column(name = "Stars")
	private Integer star;
	
	@Column(name = "Comment_Date")
	private String date;
	
	@Column(name = "Comment")
	private	String comment;

}
