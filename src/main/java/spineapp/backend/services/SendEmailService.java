package spineapp.backend.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailService {

    /**
     * Sends a given new password to a given email.
     * @param email Email where the new password will be sent to.
     * @param newPassword Password that will be sent.
     */
    public static void sendNewPassword(String email, String newPassword) {
        final String email_username = "noreply.spine.ngo@gmail.com";
        final String email_password = "rbuxgkumcuqvzwfp";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email_username, email_password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Uw nieuwe Spine-account wachtwoord");
            message.setText("Beste gebruiker, \n\n" + "Uw nieuwe wachtwoord is: " + newPassword + "\n\n" + "Met vriendelijke groet,\n" + "Het Spine-team");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}