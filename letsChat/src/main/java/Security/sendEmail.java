package Security;

import Model.User;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail {
    public void sendEmail(User user) {
        String to = user.getEmail();
        String from = "letschatsummerproject@gmail.com";
        String host = "smtp.gmail.com";
        String password = "LETSCODE212";

        //Get system properties
        Properties properties = System.getProperties();

        //Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Get the Session object and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        //Used to debug SMTP issues
        session.setDebug(true);

        try {
            //Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            //Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            //Set to: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //Set Subject: header field
            message.setSubject("This is the Subject Line!");

            //send the code
            message.setText("Your verification code is " + user.getCode());

            System.out.println("sending...");
            //send message
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
