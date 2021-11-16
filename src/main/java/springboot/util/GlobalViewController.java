package springboot.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalViewController {
	
	@GetMapping("/")
	public String inde() {
		return "frontpage";
	}
	
	@GetMapping("/about_us")
	public String about_usPage() {
		return "about_us";
	}
	@GetMapping("/change_password")
	public String change_passwordPage() {
		return "change_password";
	}
	@GetMapping("/feedback")
	public String feedbackPage() {
		return "feedback";
	}
	@GetMapping("/forget&change_pswd")
	public String forgetchange_pswdPage() {
		return "forget&change_pswd";
	}
	@GetMapping("/forget_password")
	public String forget_passwordPage() {
		return "forget_password";
	}
	@GetMapping("/frontpage")
	public String frontpagePage() {
		return "frontpage";
	}
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	@GetMapping("/order_main")
	public String order_mainPage() {
		return "order_main";
	}
	@GetMapping("/payment")
	public String paymentPage() {
		return "payment";
	}
	@GetMapping("/problem")
	public String problemPage() {
		return "problem";
	}
	@GetMapping("/product")
	public String productPage() {
		return "product";
	}
	@GetMapping("/profiles")
	public String profilesPage() {
		return "profiles";
	}
	@GetMapping("/service")
	public String servicePage() {
		return "service";
	}
	@GetMapping("/service_intro")
	public String service_introPage() {
		return "service_intro";
	}
	@GetMapping("/service-project1")
	public String serviceProject1Page() {
		return "service-project1";
	}
	@GetMapping("/service-project2")
	public String serviceProject2Page() {
		return "service-project2";
	}
	@GetMapping("/service-project3")
	public String serviceProject3Page() {
		return "service-project3";
	}
	@GetMapping("/shopping")
	public String shoppingPage() {
		return "shopping";
	}
	@GetMapping("/shopping_cart")
	public String shopping_cartPage() {
		return "shopping_cart";
	}
	@GetMapping("/Userterms")
	public String UsertermsPage() {
		return "Userterms";
	}
	@GetMapping("verify_email")
	public String verify_emailPage() {
		return "verify_email";
	}

}
