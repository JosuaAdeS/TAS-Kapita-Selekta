/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.tas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(String receiver, String subject, String bodyText) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(receiver);

            msg.setSubject(subject);
            msg.setText(bodyText);

            javaMailSender.send(msg);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
