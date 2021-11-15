package springboot.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;
import springboot.login.Login;
import springboot.login.LoginRepo;
@Log4j2
@Controller
public class GlobalViewController {

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	@Autowired
	public MailUtils mailutils;
	
	@Autowired
	LoginRepo loginRepo;
	
	@Autowired
	public changePasswordMailUtils	changePasswordMailUtils;
	
	@Autowired
	public forgetPasswordMailUtils  forgetPasswordMailUtils;
	
	@GetMapping("/")
	public String index() {
		return "frontpage";
	}
	@GetMapping("/header")
	public String header() {
		return "header";
	}
	@GetMapping("/footer")
	public String footer() {
		return "footer";
	}

	@GetMapping("/about_us")
	public String about_usPage() {
		return "about_us";
	}

	@GetMapping("/change_password")
	public String activateMail(@RequestParam String emailToken ,Model model) throws Exception {
		if (changePasswordMailUtils.balanceToken(emailToken)) {
			System.out.println("成功!!!");
			return "change_password";
		}
		System.out.println("失敗!!!");
		model.addAttribute("fail" , "fail");
		return "verify_email";

	}

	@GetMapping("/forgetPswd")
	public String forgetPswdActiveMail(@RequestParam String emailToken , Model model) throws Exception {
		if ( forgetPasswordMailUtils.balanceToken(emailToken)) {
			System.out.println("成功!!!");
			return "forgetPswd";
		}
		System.out.println("失敗!!!");
		model.addAttribute("fail","fail");
		return "forgetPswdEmail";
	}
	
	@GetMapping("/feedback")
	public String feedbackPage() {
		return "feedback";
	}


	@GetMapping("/forgetPswdEmail")
	public String forgetPswdEmailPage() {
		return "forgetPswdEmail";
	}

	@GetMapping("/frontpage")
	public String frontpagePage() {
		return "frontpage";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/maptest")
	public String maptest() {
		return "maptest";
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

	@GetMapping("/verify_email")
	public String verify_emailPage() {
		return "verify_email";
	}

	@GetMapping("/activateMail")
		public String activateMail(@RequestParam String emailToken, HttpServletResponse response) throws Exception {
			if (mailutils.balanceToken(emailToken)) {
				log.info("認證成功!");
				String member =  (String) redisTemplate.opsForValue().get(emailToken);
				String[] strs=member.split(",|=");
				String account = strs[5].toString().trim();
				 Login bean = loginRepo.findLoginByAccount(account);
				 bean.setVerification(1);
				 loginRepo.save(bean);
				 Cookie cookie = new Cookie("verification", "1"); 
				 cookie.setMaxAge(7 * 24 * 60 * 60);
				 response.addCookie(cookie);
					 return "verification";
			}
			log.info("認證失敗!");
			return "frontpage";
			}
	@GetMapping("/verification_email")
	public String verificationEmail() {
		return "verification_email";
	}
}
