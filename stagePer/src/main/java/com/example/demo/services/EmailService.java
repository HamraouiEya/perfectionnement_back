package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	    @Autowired
	    private JavaMailSender javaMailSender;

	    public void sendVerificationEmail(String to, String subject, String body) {
	        if (to != null) {
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setFrom("hamraouieya3@gmail.com");
	            message.setTo(to);
	            message.setSubject(subject);
	            message.setText(body);
	            javaMailSender.send(message);
	        } else {
	            // Handle null email address case (optional)
	            System.out.println("Email address is null. Skipping email sending.");
	        }
	    }
}
