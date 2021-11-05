package springboot.login;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Login_Controller {
	
	@PostMapping("/loginsss")
	public Login clientLogin(@RequestBody Login jsonstr) {

		System.out.println(jsonstr.getAccount());
		System.out.println(jsonstr.getPassword());
		System.out.println(jsonstr.getRememberMe());
		
		return jsonstr;
	}
	
}
