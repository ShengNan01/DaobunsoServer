package springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Component
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
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
