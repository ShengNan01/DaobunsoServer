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
@Table(name="subgrading")
public class Subgrading implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubgrading")
	private Integer id;

	@JoinColumn(name = "fk_gradingid")
	private Integer fkgid;

	@Column(name = "name")
	private String name;

	@Column(name = "content")
	private	String content;

	
}
