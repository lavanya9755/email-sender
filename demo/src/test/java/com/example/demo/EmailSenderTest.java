package com.example.demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.services.EmailService;

@SpringBootTest
public class EmailSenderTest{
//note completed
    @Autowired
    private EmailService emailService;


    @Test
    void emailSenderTest(){
        System.out.println("Sending email");
        emailService.sendEmail("chawlald@rknec.edu", "Email from spring", "ayoo whatsapp crayy");

    }
    @Test
    void sendHTML(){
        String html = "<h3 style=\"color:red; border:1px solid red;\">Hello World!</h3>\r\n";

        emailService.sendEmailwithHTML("chawlald@rknec.edu", "Email from spring",html);
    }

    @Test
    void sendemailwithfile(){
        emailService.sendEmailwithFile("chawlald@rknec.edu", "spring file test","this mail contains file ", new File("C:\\Users\\LENOVO\\OneDrive\\Desktop\\email sender\\demo\\src\\main\\resources\\static\\abc.txt"));
    }

    @Test
    void sendEmailwithStream(){
        File file = new File("C:\\Users\\LENOVO\\OneDrive\\Desktop\\email sender\\demo\\src\\main\\resources\\static\\abc.txt");
        try{
            InputStream is = new FileInputStream(file);
            emailService.sendEmailwithFile("chawlald@rknec.edu", "spring file","this email contains input filr",is);
        }catch(FileNotFoundException f){
            throw new RuntimeException(f);
        }
    }
}