package com.example.demo.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.*;

import com.example.demo.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailServiceImpl  implements EmailService{


    //if constructir nh bana can we use direct @autowired??
    @Autowired
    private JavaMailSender mailsender;
    private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);  //search kari zara

    @Autowired
    public EmailServiceImpl(JavaMailSender javamMailSender){
        this.mailsender = javamMailSender;
    }
    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("lavanyachawla24@gmail.com");
        mailsender.send(simpleMailMessage);  
        logger.info("Mail has been send ");       
        
    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom("lavanyachawla24@gmail.com");
        simpleMailMessage.setText(message);
        mailsender.send(simpleMailMessage);
        logger.info("Mail has been send ");
    }

    @Override
    public void sendEmailwithFile(String[] to, String subject, String message, File file) {
       MimeMessage mimemsg = mailsender.createMimeMessage();
       try{
        MimeMessageHelper helper = new MimeMessageHelper(mimemsg, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(message);
        helper.addAttachment(file.getName(), file);
        mailsender.send(mimemsg);
        logger.info("Mail has been sent.");
        }catch (MessagingException e) {
            e.printStackTrace();
       }
        
    }

    @Override
    public void sendEmailwithHTML(String to, String subject, String htmlCode) {
        try {
            MimeMessage simpleMailMessage = mailsender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage, true, "utf-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("lavanyachawla24@gmail.com");
            helper.setText(htmlCode, true); 
            mailsender.send(simpleMailMessage);
            logger.info("Mail has been sent.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void sendEmailwithFile(String to, String subject, String message, File file) {
        MimeMessage mimemsg = mailsender.createMimeMessage();
        try{
         MimeMessageHelper helper = new MimeMessageHelper(mimemsg, true);
         helper.setTo(to);
         helper.setSubject(subject);
         helper.setText(message);
         helper.addAttachment(file.getName(), file);
         mailsender.send(mimemsg);
         logger.info("Mail has been sent.");
         }catch (MessagingException e) {
             e.printStackTrace();
        }
    }
    @Override
    public void sendEmailwithFile(String to, String subject, String message, InputStream ins) {
        MimeMessage mimemsg = mailsender.createMimeMessage();
        try{
         MimeMessageHelper helper = new MimeMessageHelper(mimemsg, true);
         helper.setTo(to);
         helper.setSubject(subject);
         helper.setText(message);
         File file = new File("src/main/resources/email/test.txt");
         Files.copy(ins,file.toPath(),StandardCopyOption.REPLACE_EXISTING);
         FileSystemResource fileSystemResource = new FileSystemResource(file);
         helper.addAttachment(fileSystemResource.getFilename(), file);
         mailsender.send(mimemsg);
         logger.info("Mail has been sent.");
         }catch (MessagingException e) {
             e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } }
    
    
    
        
        
    
    
}
