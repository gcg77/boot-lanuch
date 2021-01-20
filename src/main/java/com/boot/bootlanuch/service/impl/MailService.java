package com.boot.bootlanuch.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author Administrator
 */
@Service
public class MailService {
    @Resource
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     * 发送文本邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

    }

    /**
     * 发送Html邮件
     *
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    /**
     *发送Html邮件-带附件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     */
    public void sendAttachmentMail(String to, String subject, String content,String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        FileSystemResource file=new FileSystemResource(new File(filePath));
        String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName,file);
        mailSender.send(message);
    }

    /**
     * 发送Html邮件-带内联附件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     * @throws MessagingException
     */
    public void sendResourceMail(String to, String subject, String content,String rscPath,String rscId) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        FileSystemResource file=new FileSystemResource(new File(rscPath));
        helper.addInline(rscId,file);
        mailSender.send(message);
    }
}
