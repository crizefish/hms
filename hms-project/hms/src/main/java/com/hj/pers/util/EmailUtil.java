package com.hj.pers.util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;

	@SpringBootTest
	@ActiveProfiles("163")
	public class EmailUtil {

	    @Autowired
	    private JavaMailSender mailSender; //自动注入的Bean

	    @Value("${spring.mail.username}")
	    private String Sender; //读取配置文件中的参数

	    @Test
	    public void sendSimpleMail() throws Exception {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(Sender);
	        message.setTo(Sender); //自己给自己发送邮件
	        message.setSubject("主题：简单邮件");
	        message.setText("测试邮件内容");
	        mailSender.send(message);
	    }
}
