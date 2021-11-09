package springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springboot.Filter.MVC_interceptor;

/*
Configuration配置文件
proxyBeanMethods代理方法(boot預設為true)
Full(proxyBeanMethods=true)singleton?
Lite(proxyBeanMethods=false)prototype?
request 不同請求獲取不同物件，同一個請求獲取同一物件
如果proxyBeanMethods代理方法 = true，那外部不管對配置中的物件調用多少次皆為相同內容，
代表物件具有唯一性與實例，可讓兩種物件產生依賴關係。
@Configuration(proxyBeanMethods = true)
@Import({User.class,DBHelper.class})給容器自動創建出這兩個類別
*/
//@Import({Holo.class,Games.class,Music.class})
//@PropertySource("MCV_config.properties")//psrc指定properties檔案路徑
//@EnableConfigurationProperties(Games.class)//開啟配置綁定，讓組件自動配置到容器中
//@EnableConfigurationProperties(Music.class)
@EnableTransactionManagement//可執行交易
@ComponentScan
//@EnableWebMvc
@Configuration
public class MVC_config implements WebMvcConfigurer {
	@Bean("Email")
	public SimpleMailMessage templateSimpleMessage() {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setText(
	      "jsjh355099@gmail.com");
	    return message;
	}
}
