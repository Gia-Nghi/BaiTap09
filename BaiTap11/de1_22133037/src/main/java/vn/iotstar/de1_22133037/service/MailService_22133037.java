package vn.iotstar.de1_22133037.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class MailService_22133037 {

    private final String FROM_EMAIL =
            "YOUR_EMAIL@gmail.com";

    private final String APP_PASSWORD =
            "YOUR_GMAIL_APP_PASSWORD";

    public void sendOTP(
            String to,
            String otp) {

        Properties props =
                new Properties();

        props.put(
                "mail.smtp.auth",
                "true"
        );

        props.put(
                "mail.smtp.starttls.enable",
                "true"
        );

        props.put(
                "mail.smtp.host",
                "smtp.gmail.com"
        );

        props.put(
                "mail.smtp.port",
                "587"
        );

        Session session =
                Session.getInstance(
                        props,
                        new Authenticator() {

                            @Override
                            protected PasswordAuthentication
                            getPasswordAuthentication() {

                                return new PasswordAuthentication(
                                        FROM_EMAIL,
                                        APP_PASSWORD
                                );
                            }
                        }
                );

        try {

            Message message =
                    new MimeMessage(session);

            message.setFrom(
                    new InternetAddress(
                            FROM_EMAIL
                    )
            );

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );

            message.setSubject(
                    "OTP Dang ky tai khoan - DE1"
            );

            message.setText(
                    "Ma OTP cua ban la: "
                    + otp
                    + "\nMa OTP co hieu luc trong 5 phut."
            );

            Transport.send(message);

        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }
    }
}