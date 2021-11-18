package springboot.language;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

//連接上攜帶區域訊息 (自創區域訊息解析器)

public class MyLocaleResolver implements LocaleResolver {

	@Override 
	public Locale resolveLocale(HttpServletRequest request) {
		String l = request.getParameter("l"); 							//參數帶l
		Locale locale = Locale.getDefault();  						    //沒帶l就用預設值
		if(!StringUtils.isEmpty(l)) {  									//若參數不為空(表示有帶上區域訊息)
			String[] split = l.split("_"); 								//用下底線將語言代碼與國家代碼分割出來
			locale = new Locale(split[0],split[1]);
		}
		return locale;
	} 
		

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
			
	}
	
	


}
