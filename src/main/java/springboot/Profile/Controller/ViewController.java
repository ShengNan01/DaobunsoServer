package springboot.Profile.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/profiles")
	public String profilePage() {
		return "profiles";
		
	}
}
