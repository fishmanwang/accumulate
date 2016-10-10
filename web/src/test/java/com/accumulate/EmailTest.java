package com.accumulate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Created by tjwang on 2016/10/10.
 */
public class EmailTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/conf/email.xml");
        JavaMailSender sender = (JavaMailSender)context.getBean("javaMailSender");

        //创建基本邮件信息
        MailMessage mailMessage = new SimpleMailMessage();

        //发送者地址，必须填写正确的邮件格式，否者会发送失败
        mailMessage.setFrom("ngiam@jingantech.com");
        //邮件主题
        mailMessage.setSubject("测试邮件");
        //邮件内容，简单的邮件信息只能添加文本信息
        mailMessage.setText("aaa");
        //邮件接收者的邮箱地址
        mailMessage.setTo("379590010@qq.com");

        sender.send((SimpleMailMessage)mailMessage);

    }

}
