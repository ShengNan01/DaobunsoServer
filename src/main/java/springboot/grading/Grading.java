package springboot.grading;

import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

//@Component
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="grading")
public class Grading implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Grading_id")
	private Integer objectid;

	@JoinColumn(name = "Account",table = "member",referencedColumnName = "Account")
	private String account;

	@Column(name = "Stars")
	private Integer star;

	@Column(name = "Comment_Date")
	private String date;

	@Column(name = "Comment")
	private	String comment;

	
}
