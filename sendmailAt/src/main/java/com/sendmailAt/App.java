package com.sendmailAt;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App {
	public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
			String subject, String message, String[] attachFiles) throws AddressException, MessagingException {
		
//		String[] mailTo = {"aakashsharma@weathersysbkc.com"};
		
		//String[] mailTo = { "bk@weathersysbkc.com", "adarshranjan@weathersysbkc.com", "ananya@weathersysbkc.com",
		//"garima_rastogi@weathersysbkc.com", "shrutipriya@weathersysbkc.com", "shalupriya@weathersysbkc.com" };
		
//		String[] mailTo = { "bk@weathersysbkc.com", "purnima.nair@weathersysbkc.com", "atyavendra.rav@weathersysbkc.com",
//				"garima_rastogi@weathersysbkc.com", "vishwadeep@weathersysbkc.com" ,"abhishek.pathak@weathersysbkc.com" , "mayank.kumar@weathersysbkc.com" ,"ankit.kumar@weathersysbkc.com"};

		String[] mailTo = {"shakil.ahmad@weathersysbkc.com"};
//				"garima_rastogi@weathersysbkc.com", "vishwadeep@weathersysbkc.com" ,"abhishek.pathak@weathersysbkc.com" , "mayank.kumar@weathersysbkc.com" ,"ankit.kumar@weathersysbkc.com"};

		
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", userName);
		properties.put("mail.password", password);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		try {
			msg.setFrom(new InternetAddress(userName));

			InternetAddress[] toAddresses = new InternetAddress[mailTo.length];
			for(int i=0; i< mailTo.length; i++) {
				toAddresses[i]= new InternetAddress(mailTo[i]);
			}

			msg.setRecipients(Message.RecipientType.TO, toAddresses);

//	   	        InternetAddress[] toAddresses1 = { new InternetAddress(mailTo1) };
//	   	        msg.setRecipients(Message.RecipientType.TO,toAddresses1);
//	   	        
//	   	        InternetAddress[] toAddresses2 = { new InternetAddress(mailTo2) };
//	   	        msg.setRecipients(Message.RecipientType.TO,toAddresses2);
//	   	        
//	   	        InternetAddress[] toAddresses3 = { new InternetAddress(mailTo3) };
//	   	        msg.setRecipients(Message.RecipientType.TO,toAddresses3);

		} catch (Exception em) {
			em.printStackTrace();
		}

		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		if (attachFiles != null && attachFiles.length > 0) {
			for (String filePath : attachFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();

				try {
					attachPart.attachFile(filePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				multipart.addBodyPart(attachPart);
			}
		}

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);

	}

	/**
	 * Test sending e-mail with attachments
	 */
	public static void main(String[] args) {
		// SMTP info
		String host = "smtp.mail.yahoo.com";
		String port = "587";
		String mailFrom = "aakashsharma@weathersysbkc.com";
//		String mailFrom = "sumit.sharma@weathersysbkc.com";
		
		String password = "obfsvfhulovbpmtr";

		// message info

		String subject = "Daily User logs and daily advisory";
		String message = "Dear Sir," + "<br/>" + "<br/>" + "Please find user logs details with farmer's daily advisory." + "<br/>" + "<br/>";

		// attachments
		String[] attachFiles = new String[1];
//		attachFiles[0] = "/home/dmdd/Desktop/fasalsalahfeedback/logDetails.xls";
//		attachFiles[1] = "/home/dmdd/Desktop/fasalsalahfeedback/7607451797_11_87_hi.txt";
//		attachFiles[2] = "/home/dmdd/Desktop/fasalsalahfeedback/8000534190_1_419_hi.txt";
//		attachFiles[3] = "/home/dmdd/Desktop/fasalsalahfeedback/8708767160_1_452_hi.txt";
//		attachFiles[4] = "/home/dmdd/Desktop/fasalsalahfeedback/8719873230_11_113_hi.txt";
//		attachFiles[5] = "/home/dmdd/Desktop/fasalsalahfeedback/9660409814_19_96_hi.txt";
		
		attachFiles[0] = "/home/dmdd/Documents/DAR_FILE.xls";
		
//		attachFiles[0] = "/home/dmdd/Desktop/fasalsalahfeedback/logDetails.xls";
//		attachFiles[1] = "/home/dmdd/Desktop/fasalsalahfeedback/7906785666_1_516_hi.txt";
//		attachFiles[2] = "/home/dmdd/Desktop/fasalsalahfeedback/7817050804_1_190_hi.txt";
//		attachFiles[3] = "/home/dmdd/Desktop/fasalsalahfeedback/9627800249_1_79_hi.txt";
//		
//		attachFiles[4] = "/home/dmdd/Desktop/fasalsalahfeedback/8777305878_1_106_hi.txt";
//		attachFiles[5] = "/home/dmdd/Desktop/fasalsalahfeedback/8168775949_1_106_hi.txt";
//		
//		attachFiles[6] = "/home/dmdd/Desktop/fasalsalahfeedback/7017200262_1_106_hi.txt";
//		attachFiles[7] = "/home/dmdd/Desktop/fasalsalahfeedback/9971863880_20_41_hi.txt";
//		attachFiles[8] = "/home/dmdd/Desktop/fasalsalahfeedback/9759101699_11_1_hi.txt";
//		
//		attachFiles[9] = "/home/dmdd/Desktop/fasalsalahfeedback/9650438186_1_106_hi.txt";
//		attachFiles[10] = "/home/dmdd/Desktop/fasalsalahfeedback/9005565816_1_106_hi.txt";
//		attachFiles[11] = "/home/dmdd/Desktop/fasalsalahfeedback/9389056290_1_361_hi.txt";
//		attachFiles[12] = "/home/dmdd/Desktop/fasalsalahfeedback/8209603804_20_16_hi.txt";
//		
//		attachFiles[13] = "/home/dmdd/Desktop/fasalsalahfeedback/8077561959_11_1_hi.txt";
//		attachFiles[14] = "/home/dmdd/Desktop/fasalsalahfeedback/7878190240_20_45_hi.txt";
//		attachFiles[15] = "/home/dmdd/Desktop/fasalsalahfeedback/6377064542_20_66_hi.txt";
//		
//		
//		

		try {
			sendEmailWithAttachments(host, port, mailFrom, password, subject, message, attachFiles);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}

}
