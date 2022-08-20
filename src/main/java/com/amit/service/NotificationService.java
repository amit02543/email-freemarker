package com.amit.service;

import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface NotificationService {

    String testEndpoint();

    void sendEmailNotification() throws MessagingException, IOException, TemplateException;

}
