package com.cy.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	@Override
	public void sendTextMailService(String to, String subject, String text) {
		System.out.println(from);
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(text);
		mailSender.send(mail);
	}
	@Override
	public void sendHtmlMailService(String to, String subject, String text) {
		MimeMessage mail = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail);
		try {
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text,true);
			mailSender.send(mail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void sendAttachmentsMailService(String to, String subject, String text ,String filePath) {
		MimeMessage mail = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			FileSystemResource resource = new FileSystemResource(new File(filePath));
			String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
			helper.addAttachment("filetest", resource);
			mailSender.send(mail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
