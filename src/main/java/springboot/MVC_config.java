package springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import springboot.language.MyLocaleResolver;

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
//@EnableWebMvc
@EnableTransactionManagement // 可執行交易
@ComponentScan
@Configuration
public class MVC_config implements WebMvcConfigurer {
	// Redis NoSQL 信箱驗證資料庫API
	@Bean
	public RedisTemplate<String, Object> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(redisConnectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
		return template;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}

//       @Bean
//       public LocaleResolver localeResolver() {
//           // 也可以换成 SessionLocalResolver, 区别在于国际化的应用范围
//           CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//           localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
//           return localeResolver;
//       }

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		// Defaults to "locale" if not set
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}

//	//默認解析器 其中locale表示默認語言,當請求中未包含語種信息，則設置默認語種當前默認為TAIWAN, zh_TW
//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(prefix = "spring.mvc", name = "locale")
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.TAIWAN);
//        return slr;
//    }
//    
	// 默認攔截器 其中lang表示切換語言的參數名
//     @Bean
//     public LocaleChangeInterceptor localeChangeInterceptor() {
//         LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//         lci.setParamName("lang");
//         return lci;
//     }

//     @Override
//     public void addInterceptors(InterceptorRegistry registry){
//         registry.addInterceptor(localeChangeInterceptor());
//     }

}
