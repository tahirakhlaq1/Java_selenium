package com.cd.generic;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailLib {
	
	
	public static void sendEmail() throws EmailException {

	  // Create the attachment
	  EmailAttachment attachment = new EmailAttachment();
	  attachment.setPath("/home/tahir/Downloads/selenium/test-output/emailable-report.html");
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  String fileName = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss'.html'").format(new Date());
	  attachment.setName("Execution Report"+fileName);

	  // Create the email message
	  MultiPartEmail email = new MultiPartEmail();
	  email.setHostName("smtp.gmail.com");
	  email.setSmtpPort(465);
	  email.setAuthenticator(new DefaultAuthenticator("tahir.akhlaq@collegedekho.com", "tahir0453!"));
	  email.setSSLOnConnect(true);
	  email.addCc("sawan.mehta@collegedekho.com", "Sawan");
	  email.addTo("vinaymalik@girnarsoft.com", "Vinay");
	  email.setFrom("tahir.akhlaq@collegedekho.com", "Selenium");
	  email.setSubject("HTML Test Report");
	  email.setMsg("Please Find the test Execution Report");

	  // add the attachment
	  email.attach(attachment);

	  // send the email
	  email.send();

}
	}
