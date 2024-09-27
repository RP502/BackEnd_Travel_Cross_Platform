package com.java.travel_cross_platform_be.Service.Interface;

import jakarta.mail.MessagingException;

public interface MailService {
    void sendVerificationMail(String to, String subject, String text) throws MessagingException;
}
