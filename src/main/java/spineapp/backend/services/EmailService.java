package spineapp.backend.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    private static final String email = "noreply.spine.ngo@gmail.com";
    private static final String password = "rbuxgkumcuqvzwfp";

    /**
     * Sends a given new password to a given email.
     * @param email Email where the new password will be sent to.
     * @param newPassword Password that will be sent.
     */
    public static void sendNewPassword(String email, String newPassword) {
        String subject = "Uw nieuwe Spine-account wachtwoord";
        String text = "Uw nieuwe wachtwoord is: " + newPassword;

        sendEmail(email, subject, text);
    }

    private static void sendEmail(String recipientEmail, String messageSubject, String messageText) {
        Properties properties = createProperties();
        Session session = createSession(properties, email, password);

        try {
            Transport.send(createMessage(session, recipientEmail, messageSubject, messageText));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties createProperties() {

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        return properties;
    }

    private static Session createSession(Properties properties, String email, String password) {
        Session session = Session.getInstance(
                properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        return session;
    }

    private static Message createMessage(Session session, String recipientEmail, String messageSubject, String messageText) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from@gmail.com"));

        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(recipientEmail)
        );
        message.setSubject(messageSubject);
        message.setText("Beste gebruiker, \n\n" + messageText + "\n\n" + "Met vriendelijke groet,\n" + "Het Spine-team");

        return message;
    }
}