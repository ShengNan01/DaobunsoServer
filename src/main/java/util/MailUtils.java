//package util;
//
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//
//import springboot.register.MemberBean;
//
//public class MailUtils {
//	@Autowired
//	private JavaMailSender mailSender;
//
//	public boolean sendEmail(MemberBean member, String email) {
//				try {
//					SimpleMailMessage message = new SimpleMailMessage();
//					message.setFrom("grfmbiu324568@gmail.com");
//					message.setTo(email);
//					message.setSubject("Daobunso信箱驗證信");
//					String emailToken = getEmailToken(member);
//					message.setText("<a href='https://localhost:8443/activateMail?emailToken=" + emailToken + "'>啟用"
//							+ "</a></br><h1>如果以上超連線無法訪問，請將以下網址複製到瀏覽器位址列中</h1><h2>https://localhost:8443/activateMail?emailToken="
//							+ emailToken + "</h2>");
//					new Thread() {
//						@Override
//			            public void run(){
//					mailSender.send(message);
//						}
//					}.start();
//				} catch (Exception e) {
//					e.printStackTrace();
//					return false;
//				}
//		return true;
//	}
//
//	public String getEmailToken(MemberBean member) {
//		String token = UUID.randomUUID().toString();
//		String value = member.toString();
//		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//		redisTemplate.opsForValue().set(token, value);
//		redisTemplate.expire(token, 60, TimeUnit.SECONDS);
//		return token;
//	}
//
//	public boolean balanceToken(String emailToken) {
//		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//		if (redisTemplate.opsForValue().get(emailToken) != null) {
//			return true;
//		}
//		return false;
//	}
//}
