package com.cybaemtech.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
    private static final Logger logger = LogManager.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailProperties mailProperties;

    public boolean sendEmail(final String content, final String recipientMail, final String subject)
    {
        try
        {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(recipientMail);
            message.setSubject(subject);
            message.setText(content);
            message.setFrom(mailProperties.getUsername());

            mailSender.send(message);

            logger.info("email send status {}", false);

            return true;
        }
        catch (final Exception e)
        {
            logger.error("Failed to send sms to user email : {}, due to {} ..", recipientMail, e.getMessage());
            logger.trace(e.getMessage(), e);

            return false;
        }
    }
}
