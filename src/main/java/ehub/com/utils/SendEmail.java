package ehub.com.utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public static void main(String[] args) {
		// authentication info
		final String username = "pankajyadavebix@gmail.com";
		final String password = "pdbz shul nfye sdni";
		String fromEmail = "pankajyadavebix@gmail.com";
		String toEmail = "ramakrishna.jammi@Ebix.com";
		//String toEmail2 = "pankajyadavebix@gmail.com";
		//String toEmail3 = "pankajyadavebix@gmail.com";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			//msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail2));
			//msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail3));
			msg.setSubject("Exposure Hub Automation Test Report - Environment Health Check");

			Multipart emailContent = new MimeMultipart();

			// Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Hi, Execution is successfuly. Please find the attached file of test report.\n\nNote : This Email is sent by Automation Test script after post test suite.");

			// Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			pdfAttachment.attachFile(System.getProperty("user.dir")+"\\reports\\TestExecutionReport.html");

			// Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);

			// Attach multipart to message
			msg.setContent(emailContent);

			Transport.send(msg);
			System.out.println("Sent Email Successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
	}
}
