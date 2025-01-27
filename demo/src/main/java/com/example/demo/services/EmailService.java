package com.example.demo.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    //send email
    void sendEmail(String to, String subject , String message);

    void sendEmail(String []to, String subject , String message);

    void sendEmailwithHTML(String to, String subject , String htmlCode);

    void sendEmailwithFile(String []to, String subject , String message,File file);

    void sendEmailwithFile(String to, String subject, String message, File file);

    void sendEmailwithFile(String to, String subject, String message, InputStream ins);

    


}
