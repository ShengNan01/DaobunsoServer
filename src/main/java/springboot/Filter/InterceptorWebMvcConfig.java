package springboot.Filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

	

@Configuration
public class InterceptorWebMvcConfig implements WebMvcConfigurer {
	
	List<String> url = Arrays.asList(
			"/profiles/**",
			"/orders/**",
			"/feedback/**",
			"/payment/**"
		);
	
	@Autowired
	private MVC_interceptor interceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns(url)
        .excludePathPatterns("/","/css/**","/js/**","/image/**");
	}

}
