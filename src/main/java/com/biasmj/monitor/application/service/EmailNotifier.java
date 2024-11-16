package com.biasmj.monitor.application.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

public interface EmailNotifier {
    void execute();

    @Service
    @RequiredArgsConstructor
    class EmailNotifierService implements EmailNotifier {
        private static final Logger logger = LoggerFactory.getLogger(EmailNotifierService.class);
        private final JavaMailSender mailSender;

        @Value("${notifier.title}")
        private String mailTitle;

        @Value("${notifier.content}")
        private String mailContent;

        @Value("${notifier.recipient-email}")
        private String recipientEmail;

        @Override
        public void execute() {
            try {
                mailSender.send(mailConfig());
                logger.info("Email sent successfully to {}", recipientEmail);
            } catch (Exception e) {
                logger.error("Failed to send email to {}", recipientEmail, e);
            }
        }

        private SimpleMailMessage mailConfig() {
            var message = new SimpleMailMessage();
            message.setTo(recipientEmail);
            message.setSubject(mailTitle);
            message.setText(mailContent);
            return message;
        }
    }
}