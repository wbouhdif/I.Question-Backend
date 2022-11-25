package spineapp.backend.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailService {

    public void SendNewPassword(String email, String newPassword) {
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

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    private static SendEmailService instance;
    public static SendEmailService getInstance() {
        if (instance == null) {
            instance = new SendEmailService();
        }
        return instance;
    }
}