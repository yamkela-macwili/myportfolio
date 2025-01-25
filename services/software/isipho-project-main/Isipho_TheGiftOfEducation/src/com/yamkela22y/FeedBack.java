//Sends an email
package com.yamkela22y;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author YAMKELA MACWILI
 */
public class FeedBack {
    
    private  String ApplicantName;   //To store the applicants names 

    
    /**
     * 
     * @param ApplicantName Sets names from the application
     */
    public void setApplicantName(String ApplicantName){ //

        this.ApplicantName =  ApplicantName;          
    }
    
    /**
     * 
     * @param recipientMail 
     * @throws Exception 
     */
    public void sendMail(String recipientMail) throws Exception {
        
        Properties properties = new Properties();
        
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            //Sender email
            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("isiphog3@gmail.com", "isipho2021");   
                    return new PasswordAuthentication("isiphog3@gmail.com", "vxhoobsjcjtbjoro");   
            }
        });

        Message message = new MimeMessage(session);
        
        //Subject of the email
        message.setSubject("Application with Isipho"); 
        //The content/body of the email
        message.setContent(
             
                "Dear " + ApplicantName  
                
                + "<br><br>This is a comfirmaion that ISipho is currently busy with your applicatoion. <br><br>"
                + "NB: Please be reminded that Isipho does not keep any of your application details,"
                        + "and therefore does not keep track of your application status. "
                        + "If you need any assistance you will be required to provide your details. <br><br>"
                        + "Contact us on: <br>"
                        + "Call: 078 016 0495 | 083 728 6896 | 063 859 5244 <br>"
                        + "Email: isiphog3@gmail.com"        
                + "<br><br>Thank you <br> Isipho  ", "text/html");

        //Address address = new InternetAddress("keanuperumal8@gmail.com"); //The recepient address
        Address recipientAddress = new InternetAddress(recipientMail); //The recepient address from the main class
        Address localAddress = new InternetAddress("isiphog3@gmail.com"); //the sender address
        message.setRecipient(Message.RecipientType.TO, recipientAddress);    //setting the recipient 
        
        message.setFrom(localAddress);      //setting the sender address

        Transport.send(message);        //sending the email
        JOptionPane.showMessageDialog(null, "Email sent to "+ ApplicantName);
    }
    
    
}
