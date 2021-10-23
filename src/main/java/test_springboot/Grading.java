package test_springboot;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Component
@ToString
@Data
//@ConfigurationProperties(prefix = "feedback")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="grading")
public class Grading implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Grading_Id")
	private Integer objectid;
	
	@Column(name = "Account")
	private String user_account;
	
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

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
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
