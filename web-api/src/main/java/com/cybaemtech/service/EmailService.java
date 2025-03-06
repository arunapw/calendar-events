package com.cybaemtech.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
    private static final Logger logger = LogManager.getLogger(EmailService.class);

    public boolean sendEmail(final String content)
    {
        //TODO : WRITE EMAIL SENDER LOGIC
        logger.info("email send status {}", false);

        return false;

    }
}
