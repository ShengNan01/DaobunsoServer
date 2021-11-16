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

public class forgetPasswordMailUtils {
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(MemberBean member, String email) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("daobunso.company@gmail.com");
			helper.setTo(email);
			helper.setSubject("Daobunso忘記密碼驗證信");
			String emailToken = getEmailToken(member);
			helper.setText("<h3><a href='https://localhost/forgetPswd?emailToken=" + emailToken + "'>請點擊進入忘記密碼頁面</h3>"
					+ "</a></br><h3>如果以上超連結無法訪問，請將以下網址複製到瀏覽器位址列中</h3><h3>https://localhost/forgetPswd?emailToken="
					+ emailToken + "</h3>", true);
			new Thread() {
				@Override
				public void run() {
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
		System.out.println(value);
		redisTemplate.opsForValue().set(token, value);
		redisTemplate.expire(token, 60, TimeUnit.SECONDS);
		return token;
	}

	// 確認redis內有沒有資料
	public boolean balanceToken(String emailToken) throws Exception {
		if (redisTemplate.opsForValue().get(emailToken) != null) {
			return true;
		}
		return false;
	}

}
