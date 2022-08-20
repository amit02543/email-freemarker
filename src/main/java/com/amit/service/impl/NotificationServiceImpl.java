package com.amit.service.impl;

import com.amit.config.EmailConfig;
import com.amit.dao.ApplicationDao;
import com.amit.service.NotificationService;
import com.amit.util.MockData;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender emailSenderConfig;

    @Autowired
    private Configuration freeMarkerConfig;

    @Autowired
    private ApplicationDao dao;

    @Autowired
    private MockData mockData;


    @Override
    public String testEndpoint() {
        return dao.testEndpoint();
    }

    @Override
    public void sendEmailNotification() throws MessagingException, IOException, TemplateException {
        log.info("Send Email Notification Process Start");

        //TODO: fetch email body content
        List<Map<String, Object>> emailBody = mockData.getEmailMockData();

        MimeMessage message = emailSenderConfig.createMimeMessage();

        Map<String, Object> model = new HashMap<>();
        model.put("jobStatuses", emailBody);


        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED);

        Template template = freeMarkerConfig.getTemplate("job-status-notification.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);


        helper.setFrom(new InternetAddress(emailConfig.getSenderEmail(), "Email Sender Admin"));
        helper.setText(html, true);
        helper.setSubject("JOB Status Notification");
        helper.setTo(emailConfig.getRecipientEmail());
        //helper.addAttachment("error.txt", new File(filePath));


        emailSenderConfig.send(message);
    }


}
