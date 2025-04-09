package com.fastcampus.trustRide.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@PropertySource("classpath:mail.properties")
public class EmailAuthService {

    @Value("${mail.username}")
    private String fromEmail;

    private final JavaMailSender mailSender;
    private final Map<String, VerificationCode> codeStorage = new HashMap<>();

    @Autowired
    public EmailAuthService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public boolean sendCode(String toEmail, HttpServletRequest request) {
        String code = createCode();
        VerificationCode verificationCode = new VerificationCode(code);
        codeStorage.put(toEmail, verificationCode);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

            helper.setTo(toEmail);
            helper.setFrom(fromEmail);
            helper.setSubject("[Trust Ride] 이메일 인증번호입니다.");

            ClassPathResource resource = new ClassPathResource("templates/email-template.html");
            String html = Files.readString(resource.getFile().toPath());

            html = html.replace("${code}", code);
            helper.setText(html, true);

            mailSender.send(message);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean verifyCode(String email, String inputCode) {
        VerificationCode storedCode = codeStorage.get(email);
        if (storedCode == null) return false;

        // 3분 초과 여부 확인
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(storedCode.getCreatedTime().plusMinutes(3))) {
            return false;
        }

        return storedCode.getCode().equals(inputCode);
    }

    private String createCode() {
        int code = new Random().nextInt(900000) + 100000;
        return String.valueOf(code);
    }
}
