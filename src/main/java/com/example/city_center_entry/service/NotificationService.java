package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Car;
import com.example.city_center_entry.entity.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class NotificationService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Autowired
    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notifyAdminAboutNewRequestForAddCar(Car car) {
        //notify admin about request for add new car
    }

    public void notifyEntry(Entry entry) {
        //notify owner about entry and obligation to pay a bill

    }

    public void notifyLongDurationStay(Entry entry) {
        //if car was more then particular time in city center, it notify user and admin and may send a fee for it
//        if ( entry.getDateOfExit().getTime() - entry.getDateOfEntry().getTime())  > // send message }
    }

    public void notifyChangeInOutPoint(Entry entry) {
            //notify if auto in and out using different entry points and may send a fee for it
            if (entry.getPointExit()!=entry.getPointEntry()) return;// send message
    }

    public void notifyPolice(Entry entry) {
        //notify police
    }

    public void notifyApproveRequest(Car car) {
        //vznik danovej povinnosti
        //notify about approved request
    }


    public void notifyRefuseRequest(Car car) {
    //send email about refuse
    }


    public void notifyAboutUncompleteDoc(String email) {
        //send email about uncompleted application
    }

    @Async
    public void send(String to, String email, String theme) {
//        try {
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//            helper.setText(email, true);
//            helper.setTo(to);
//            helper.setSubject(theme);
//            helper.setFrom(mailFrom);
//
//            mailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            throw new IllegalStateException("failed to send email");
//        }
    }
}
