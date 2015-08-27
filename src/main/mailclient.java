package com.vzb.gch.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// Need mail-1.4.4.jar

public class SendEmailByProperties {
	private String host;
	private String from;
	private String to;
	private String fileAttachment;
	private String mailHost;
	private String attachmentRequired;
	
	public SendEmailByProperties(String fileName) {

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(fileName);
			// load a properties file
			prop.load(input);
			this.host = prop.getProperty("host");
			this.from = prop.getProperty("from");
			this.to = prop.getProperty("to");
			this.fileAttachment = prop.getProperty("fileAttachment");
			this.mailHost = prop.getProperty("mailHost");
			this.attachmentRequired = prop.getProperty("attachmentRequired");
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void sendEmail() throws AddressException, MessagingException {

		// Get system properties
		Properties props = System.getProperties();

		// Setup mail server
		props.put("mail.transport.protocol", this.host);
		props.put("mail.host", this.mailHost);
		props.put("mail.smtp.host", this.mailHost);
		props.put("mail.from", this.from);
		props.put("mail.debug", true);

		// Get session
		Session session = Session.getInstance(props, null);

		// Define message
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		
		String[] toAddr  =to.split(",");
		for(String toEmail : toAddr) {
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
		}
		
		message.setSubject("Hello JavaMail Attachment");

		// create the message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();

		// fill message
		messageBodyPart.setText(convertFileToString(this.fileAttachment));

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment
		if("Y".equalsIgnoreCase(this.attachmentRequired)) {
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(this.fileAttachment);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(this.fileAttachment);
			multipart.addBodyPart(messageBodyPart);
		}
		// Put parts in message
		message.setContent(multipart);

		Transport.send(message);

	}
	
public String convertFileToString(String filePath) {
	
    File file = new File(filePath);

    FileInputStream fis = null;
    String str = "";

    try {
        fis = new FileInputStream(file);
        int content;
        while ((content = fis.read()) != -1) {
            // convert to char and display it
            str += (char) content;
        }

        System.out.println("After reading file");
        System.out.println(str);

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (fis != null)
                fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
return str;
}

	public static void main(String args[]) throws Exception {
		System.out.println("===============START=================");
		if(args[0] == null)
			new SendEmailByProperties("config.properties").sendEmail();
		else  {
			new SendEmailByProperties(args[0]).sendEmail();
		}
		System.out.println("===============END=================");
	}

}
