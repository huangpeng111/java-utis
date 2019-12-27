package com.cy.mail.service;

public interface MailService {
	/**
	 * 简单邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param text  内容
	 */
	public void sendTextMailService(String to ,String subject ,String text);
	
	/**
	 * 带html格式邮件
	 * @param to
	 * @param subject
	 * @param text
	 */
	public void sendHtmlMailService(String to ,String subject ,String text );
	
	/**
	 * 带附件的邮件
	 * @param to
	 * @param subject
	 * @param text
	 */
	public void sendAttachmentsMailService(String to ,String subject ,String text ,String filePath);
}
