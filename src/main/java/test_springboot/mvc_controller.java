package test_springboot;

//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

//@ResponseBody
//@Controller
@RestController
public class mvc_controller {
	
	@RequestMapping("/exreq1")
	public String handle1() {
		return "你好 這是spring mvc controller";
	}
	
	@RequestMapping("/exreq2")
	public String handle2() {
		return "你好 你是不是在哭!spring mvc controller";
	}
	
	@RequestMapping("/hina1req")
	public String mhina1req() {
		Hina hina1 = new Hina("hina1",18,150.0,45.0,"hina!hina!hi~","dinter清起來!");
		return hina1.getFeedback();
	}
	@RequestMapping("/hina2req")
	public String mhina2req() {
		Hina hina2 = new Hina("peko",20,160.0,48.0,"peko?","HA!HA!HA!HA!");
		return hina2.getFeedback();
	}
}
