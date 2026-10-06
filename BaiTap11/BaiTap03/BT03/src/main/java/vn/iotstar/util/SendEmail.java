package vn.iotstar.util;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendEmail {

    private static final String EMAIL = "nmthu0807@gmail.com";

    
    private static final String APP_PASSWORD = "eekn odbr wzfa fexh";

    public static boolean sendOtp(String toEmail, String otp) {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new jakarta.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(
                                EMAIL,
                                APP_PASSWORD
                        );
                    }
                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(EMAIL));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );

            message.setSubject("Mã xác thực OTP");

            message.setText(
                    "Mã OTP của bạn là: " + otp
                    + "\n\nMã có hiệu lực trong 5 phút."
            );

            Transport.send(message);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}