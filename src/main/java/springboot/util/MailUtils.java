package springboot.util;

import java.util.UUID;

import java.util.concurrent.TimeUnit;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import springboot.register.MemberBean;

@Component
public class MailUtils {
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	private JavaMailSender mailSender;
	public boolean sendEmail(MemberBean member, String email) {
				try {
					MimeMessage mimeMessage = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
					helper.setFrom("grfmbiu324568@gmail.com");
					helper.setTo(email);
					helper.setSubject("Daobunso信箱驗證信");
					String emailToken = getEmailToken(member);
					helper.setText("<a href='https://localhost/activateMail?emailToken="+emailToken+"'>點我驗證啟用帳號"+"</a></br><h3>如果以上超連線無法訪問，請將以下網址複製到瀏覽器位址列中</h3><h3>https://localhost/activateMail?emailToken="+emailToken+"</h3>",true);
					new Thread() {
						@Override
			            public void run(){
					mailSender.send(mimeMessage);
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
		redisTemplate.opsForValue().set(token, value);
		redisTemplate.expire(token, 60, TimeUnit.SECONDS);
		return token;
	}

	public boolean balanceToken(String emailToken) throws Exception {
		if (redisTemplate.opsForValue().get(emailToken) != null) {
			return true;
		}
		return false;
	}
}
