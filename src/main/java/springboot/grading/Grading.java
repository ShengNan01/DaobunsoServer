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
@Entity
@Table(name="grading")
public class Grading implements Serializable{
	@Getter
	@Setter
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Grading_id")
	private Integer objectid;

	@Getter
	@JoinColumn(name = "Account",table = "member",referencedColumnName = "Account")
	private String account;

	@Getter
	@Setter
	@Column(name = "Stars")
	private Integer star;

	@Getter
	@Setter
	@Column(name = "Comment_Date")
	private String date;

	@Getter
	@Setter
	@Column(name = "Comment")
	private	String comment;



	public Integer getObjectid() {
		return objectid;
	}

	public void setObjectid(Integer objectid) {
		this.objectid = objectid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
