package com.cy.mail;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cy.service.MailService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailTest {
	@Autowired
	private MailService mailService;
	
	@Test
	public void simpleMailtest() {
		mailService.sendTextMailService("1131351503@qq.com", "java simple mail test", "spring-boot-starter-mail");
	}
	
	@Test
	public void htmlMailTest() {
		String text="<html>\n" +
	            "<body>\n" +
	            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
	            "</body>\n" +
	            "</html>";

		mailService.sendHtmlMailService("1131351503@qq.com", "html mail test", text);
		
	}
	
	@Test
	public void attachmengMailTest(){
		mailService.sendAttachmentsMailService("1131351503@qq.com", "附件", "附件测试", "E:/my/mysql.png");
	}
	
	@Test
	public void fileSeparetortest() {
		String filePath ="E:/my/mysql.png";
		String str = filePath.substring(filePath.lastIndexOf("/")+1);
		System.out.println(str);
	}
	
	@Autowired
	private TemplateEngine templateEngine;
	
	//模板邮件
	@Test
	public void thymleafHtmlMail() {
		Context context = new  Context();
		context.setVariable("id", "006");
		String text = templateEngine.process("emailTemplate",context);
		mailService.sendHtmlMailService("1131351503@qq.com", "template test", text);
	}
	
}
