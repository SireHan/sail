package com.study.spring.sail.modules.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailSenderTest {

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() {
        Context context = new Context();
        context.setVariable("id","006");
        String emailContent = templateEngine.process("/modules/home",context);
        mailSenderService.sendSimpleMail(null,"924856501@qq.com","邮件测试",emailContent);
    }
}