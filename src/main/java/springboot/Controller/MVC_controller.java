package springboot.Controller;

//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springboot.Games;
import springboot.Games_interface;
import springboot.Holo;
import springboot.Holo_interface;

import java.net.http.HttpRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
@Component 所有被控管的java類別須加此註解，以下三種註解皆為此註解的子註解。
@Repository 存取資料庫的DAO類別須加此註解，類別內方法丟出的SQLException會被轉為DataAccessException。
@Service 用於Business Service類別，又稱Facade類別，其會呼叫多種存取資料庫的方法用來完成企業邏輯運算，
通常一個@Service下的方法定義一個交易。
@Controller Spring MVC 的控制器。
 */
//@EnableWebMvc
//@ResponseBody
//@Controller
@RestController//包含Controller&ResponseBody
public class MVC_controller {
	@RequestMapping("/holo")
	public Holo_interface handle2() {
		Games_interface game_a = new Games("APEX","Shooting", true, 2);
		Holo_interface neolHolo = new Holo("Neol",22,165.0,53.0,"....!","www",game_a);
		return neolHolo;
	}
	
	
}
