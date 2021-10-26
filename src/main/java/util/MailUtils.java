package util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtils {
	//String email:用戶用來激活的郵箱
    //String emailMsg:郵件內容
    public static void sendMail(String email, String emailMsg) throws AddressException, MessagingException, GeneralSecurityException, UnsupportedEncodingException{
        
        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
        //ssl加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.setProperty("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        // 創建驗證器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("grfmbiu324568@gmail.com", "wyhjhfzkwdyplata");
            }
        };
        //創建程序到郵件服務器的第一次對話
        Session session = Session.getInstance(props, auth);
        //控制檯輸出debug信息
        session.setDebug(true);

        // 2.創建一個Message，它相當於郵件內容
        //相當於獲取信封
        Message message = new MimeMessage(session);
        //設置發送人
        message.setFrom(new InternetAddress("grfmbiu324568@gmail.com"));
        //設置發送方式與接收者
        message.setRecipient(RecipientType.TO, new InternetAddress(email));
        //郵件主題
        message.setSubject("Daobunso修改密碼");
        //郵件內容
        message.setContent(emailMsg, "text/html;charset=utf-8");

        // 3.創建 Transport用來發送郵件
        Transport.send(message);
    }

}
