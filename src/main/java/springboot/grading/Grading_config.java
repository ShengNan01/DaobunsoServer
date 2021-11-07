package springboot.grading;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springboot.Filter.MVC_interceptor;

@EnableTransactionManagement//可執行交易
@ComponentScan
@Configuration
public class Grading_config implements WebMvcConfigurer {
//	
//	@Bean("gg")
//	public Grading grading01() {
//		Grading grading = new Grading(1,"213", 2,"512", "852", null);
//		grading.setSubgrading(1,"12","123",1);
//		return grading;
//	}
}
