import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {

	public static void sendMail(String recipientName, String recipient, String service) throws Exception {
		
		Properties props = new Properties();
		
		System.out.println("Preparing to sent email to: "+recipient);
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", service);
		props.put("mail.smtp.port", "587");
		
		String sender = "mypracticemail4@gmail.com";
		String password = "test3330";
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		});
		
		Message msg = prepareMessage(session, sender, recipientName, recipient);
		
		Transport.send(msg);
		System.out.println("Message sent");
	}

	private static Message prepareMessage(Session session, String myEmail,String recipientName, String recipient) {
		// TODO Auto-generated method stub
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(myEmail));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			msg.setSubject("Happy Birthday!");
			msg.setText("Happy Birthday, dear "+recipientName+"!");
			return msg;
		}catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return null;
	}
	
}
