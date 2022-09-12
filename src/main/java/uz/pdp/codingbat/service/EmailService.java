package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/sign")
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public Boolean sendEmailMessage(String email) {
        SimpleMailMessage mailMessage
                = new SimpleMailMessage();

        // Setting up necessary details
        mailMessage.setFrom(sender);
        mailMessage.setTo(email);
        mailMessage.setText("http://localhost:8082/auth/sign/in?password=");
        mailMessage.setSubject("this mail automatically generated!!!");
        javaMailSender.send(mailMessage);
        return true;

    }

    public void sendEmailVerificationCode(String email, UUID emailCode) {
        SimpleMailMessage mailMessage
                = new SimpleMailMessage();

        // Setting up necessary details
        mailMessage.setFrom(sender);
        mailMessage.setTo(email);
        mailMessage.setText("http://localhost/api/auth/verification-email?code="+emailCode);
        mailMessage.setSubject("this mail automatically generated!!!");
        javaMailSender.send(mailMessage);

    }
}
