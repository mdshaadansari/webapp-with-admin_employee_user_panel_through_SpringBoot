package com.example.project3_test.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration  
public class AppConfiguration  { 
	@Bean
	public JavaMailSenderImpl JavaMailSender() {
		JavaMailSenderImpl	 mailSender = new JavaMailSenderImpl();
	     mailSender.setHost("smtp.gmail.com");
	     mailSender.setPort(587);
	     mailSender.setUsername("mdshaad0000024@gmail.com");
	     mailSender.setPassword("waxd xcaa rzps gayn");

	     // Configure SMTP properties
	     Properties props = mailSender.getJavaMailProperties();
	     props.put("mail.transport.protocol", "smtp");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.starttls.enable", "true");
	     
		return mailSender;
		
	}
	
	@Bean
	public SimpleMailMessage SimpleMailMessage() {
		return new SimpleMailMessage();
	}
}
