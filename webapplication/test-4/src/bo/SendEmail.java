package bo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entity.EmailVerify;

public class SendEmail {
	public void execute(EmailVerify emailVerify) {
		final String username = "メールアドレス";
		final String password = "パスワード";
		String recipientEmail = emailVerify.getEmail(); // 送信先のメールアドレス

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String baseUrl = "http://localhost:8080/test-4/confirm?token=";
		String url = baseUrl + emailVerify.getToken();

		System.out.println(url);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username)); // 送信元のメールアドレスを設定
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // 送信先のメールアドレスを設定
			message.setSubject("Subject");
			message.setText(url);

			Transport.send(message);

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
