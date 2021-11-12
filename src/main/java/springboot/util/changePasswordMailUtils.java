package springboot.util;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import springboot.register.MemberBean;
@Component

public class changePasswordMailUtils {
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	private JavaMailSender mailSender;
	public boolean sendEmail(MemberBean member, String email) {
				try {
					SimpleMailMessage message = new SimpleMailMessage();
					message.setFrom("grfmbiu324568@gmail.com");
					message.setTo(email);
					message.setSubject("Daobunso信箱修改密碼驗證信");
					String emailToken = getEmailToken(member);
					message.setText("<a href='https://localhost:8443/change_password?emailToken="+emailToken+"'>請點擊連結"+"</a></br><h1>\"+\"如果以上超連線無法訪問，請將以下網址複製到瀏覽器位址列中</h1><h2>http://localhost:8443/change_password?emailToken="+emailToken+"</h2>");
					new Thread() {
						@Override
			            public void run(){
					mailSender.send(message);
						}
					}.start();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
		return true;
	}
	
	public String getEmailToken(MemberBean member) throws Exception {
		String token = UUID.randomUUID().toString();
		String value = member.toString();
		System.out.println(value);
		redisTemplate.opsForValue().set(token, value);
		redisTemplate.expire(token, 60, TimeUnit.SECONDS);
		return token;
	}
	//確認redis內有沒有資料
	public boolean balanceToken(String emailToken) throws Exception {
		if (redisTemplate.opsForValue().get(emailToken) != null) {
			return true;
		}
		return false;
	}

	
}
