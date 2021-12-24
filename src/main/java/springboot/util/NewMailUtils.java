package springboot.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import springboot.register.MemberBean;

@Component
public class NewMailUtils {
	@Autowired
	public MailUtils mailUtils;

	public boolean sendEmail(MemberBean member, String email) throws Exception {

		new Thread() {
			@Override
            public void run(){
		Properties props = new Properties();
		String host = "smtp.gmail.com";
		// 下面設定是根據GMail官方文件所寫的，開啟TLS以及SMTP AUTH
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("daobunso.company@gmail.com", "dnvogsyuevpyrnig");
			}
		};
		Session session = Session.getDefaultInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(msg, true);
			helper = new MimeMessageHelper(msg, true);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String emailToken;
		try {
			emailToken = mailUtils.getEmailToken(member);
			helper.setText("<h3><a href='https://localhost/activateMail?emailToken="+emailToken+"'>點我驗證啟用帳號</h3>"+"</a></br><h3>如果以上超連線無法訪問，請將以下網址複製到瀏覽器位址列中</h3><h3>https://localhost/activateMail?emailToken="+emailToken+"</h3>",true);
			helper.setFrom("daobunso.company@gmail.com");
			helper.setTo(email);
			helper.setSubject("Daobunso信箱驗證信");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		new Thread() {
			@Override
		    public void run(){
		try {
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
			}
		}.start();

			}
		}.start();
		return true;
	}

}
