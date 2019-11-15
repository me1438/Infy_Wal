package com.infy.infywal.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail {


public String senMail() {
	
    
    String to = "xxx@infosys.com";
		
		String from = "zzzz@infosys.com"; 
	      String cc= "yyyy@infosys.com";
		
	
    String host = "0.0.0.0"; //hostname
	
   
    String[] recipientList = to.split(",");
    
  
    
    Properties properties = System.getProperties();  
    properties.setProperty("mail.smtp.host", host);  
	  properties.setProperty("mail.user", "user");                   
	properties.setProperty("mail.password", "password$$"); 
    Session session = Session.getDefaultInstance(properties);
    

    try{ 
  	  InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
	      int counter = 0;
	      for (String recipient : recipientList) {
	          recipientAddress[counter] = new InternetAddress(recipient.trim());
	          counter++;
	      }
       MimeMessage message = new MimeMessage(session);  
       message.setFrom(new InternetAddress(from));  
       message.addRecipients(Message.RecipientType.TO,recipientAddress);
       message.setRecipient(javax.mail.Message.RecipientType.CC,new InternetAddress(cc));
       message.setSubject("Account Action Items summary"); 
       //message.setContent("<p style='color:red'> Hello, this is example <b>"+emailid+"</b> of sending email </p> ","text/html");  
       message.setContent(html(),"text/html");  
       
       
       // Send message  
       Transport.send(message);  
       return "message sent successfully....";  

    }catch (MessagingException mex) {mex.printStackTrace();
    	return mex.getMessage();
    }  
	
	
}

public String html() {
	String htmlstring = "<html>"+
"<head>"+
	"<title> Walmart Account Induction - New Joiners</title>"+
"</head>"+
"<body aria-readonly='false'>Hi All,<br />"+
"<br />"+
"Good Evening!<br />"+
"<br />"+
"Walmart Induction session has been scheduled for you on February 7th 2019 @ 11 AM in B1 building Hubble Conference Room.<br />"+
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />"+
"All are invited to the Walmart Induction Session!<br />"+
"&nbsp;<br />"+
"Let&rsquo;s meet, discuss and know about our account. &nbsp;<br />"+
"&nbsp;<br />"+
"As this is a mandatory session, Kindly accept the meeting request and plan to attend the session.<br />"+
"&nbsp;<br />"+
"Regards,<br />"+
"Akshaya.</body>"+
"</html>" ;

	
	return htmlstring;
}

}