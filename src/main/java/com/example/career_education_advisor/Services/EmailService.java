package com.example.career_education_advisor.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // ================= SEND OTP EMAIL =================

    public void sendOtp(String email, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("Career & Education Advisor <YOUR_EMAIL@gmail.com>");
        message.setTo(email);

        message.setSubject("Email Verification - Career & Education Advisor");

        message.setText(
                "Hello,\n\n" +
                        "Your OTP for email verification is: " + otp + "\n\n" +
                        "This OTP is valid for 5 minutes.\n\n" +
                        "Please do not share this OTP with anyone.\n\n" +
                        "Thanks,\n" +
                        "Career & Education Advisor Team");

        mailSender.send(message);
    }
}