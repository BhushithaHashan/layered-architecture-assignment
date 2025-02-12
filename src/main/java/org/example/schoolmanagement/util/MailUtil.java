package org.example.schoolmanagement.util;



import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailUtil {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "****";
    private static final String SMTP_USER = "*********@gmail.com";
    private static final String SMTP_PASS = "************";

    private static final int MAX_THREADS = 5; // Maximum number of threads for email
    private static final ExecutorService emailThreadPool = Executors.newFixedThreadPool(MAX_THREADS);

    public static void sendEmail(String recipient, String subject, String body) {
        Runnable emailTask = () -> {
            try {
                // Set email properties
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", SMTP_HOST);
                props.put("mail.smtp.port", SMTP_PORT);

                // Authenticate the session
                Session session = Session.getInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SMTP_USER, SMTP_PASS);
                    }
                });

                // Compose the message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(SMTP_USER));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                message.setSubject(subject);
                message.setText(body);

                // Send the email
                Transport.send(message);
                System.out.println("Email sent successfully to: " + recipient);

            } catch (MessagingException e) {
                System.err.println("Error sending email to " + recipient + ": " + e.getMessage());
            }
        };

        emailThreadPool.submit(emailTask);
    }

    public static void shutdownThreadPool() {
        emailThreadPool.shutdown();
        System.out.println("Email thread pool shut down.");
    }
}
