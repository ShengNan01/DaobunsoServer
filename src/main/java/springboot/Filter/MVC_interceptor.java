package springboot.Filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
//攔截請求
@Component
public class MVC_interceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 登入檢查
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				log.info("把cookie的東西抓出來=" + cookie.getName());
				if (StringUtils.equalsIgnoreCase(cookie.getName(), "LoginOK")) {
					for(Cookie verification : cookies) {
						if (StringUtils.equalsIgnoreCase(verification.getName(), "verification")) {
							if(verification.getValue().equals("1")) {
								log.info("有驗證!");
								return true;
							}else if(verification.getValue().equals("0")) {
								log.info("沒有驗證!");
//								model.addAttribute("verificationFail", "verificationFail");
//								response.sendRedirect("/verify_email");
								return false;
							}
						}
					}
				}
			}
			log.info("cookie沒有東西,導回login頁面");
			response.sendRedirect("/login");
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
