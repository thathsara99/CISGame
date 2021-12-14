
package Server;

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

/**
 *
 * @author User
 */
public class SendEmail {
    
    /***
     * sending the email to the client
     * @param recepient
     * @param content
     * @param title
     * @return
     * @throws Exception 
     */
    public static String sendMail(String recepient, String content, String title) throws Exception {
        System.out.println("Preparing to send email");
        /***
         * configure the properties in email.
         */
        Properties properties = new Properties();  

        /***
         * Authentication needed for the email server.
         */
        properties.put("mail.smtp.auth", "true");   
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        /***
         * identifying senders email address and password.
         */
        final String myAccountEmail = "tcroos365@gmail.com";
        final String password = "it19081694";

        /***
         * login to the email
         */
        Session session = Session.getInstance(properties, new Authenticator() {

            /***
             * password authentication.
             * @return 
             */
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(myAccountEmail, password);
            }

        });

        Message message = prepareMessage(session, myAccountEmail, recepient, content, title);

        /***
         * transport the data.
         */
        Transport.send(message);
        System.out.println("Message send Successfully");
        return "Message send Successfully";
    }

    /***
     * create the message
     * @param session
     * @param myAccountEmail
     * @param recepient
     * @param content
     * @param title
     * @return 
     */
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String content, String title) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(title);  //message subject
            message.setText(content); //message body
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
