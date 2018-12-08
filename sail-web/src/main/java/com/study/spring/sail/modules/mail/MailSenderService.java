package com.study.spring.sail.modules.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailSenderService {

    private Logger logger = LoggerFactory.getLogger(MailSenderService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送邮件
     * @param from 发送人
     * @param to 接收人
     * @param subject 主题
     * @param content 内容
     */
    public boolean sendSimpleMail(String from, String to, String subject, String content){

        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            /**
             * multipart = true
             * 如果要支持内联元素(HTML)和附件就必须给定第二个参数为true
             * 否则抛出 java.lang.IllegalStateException 异常
             * encoding 如果HTML内容含有中文必须指定HTML的编码,默认是ISO-8859-1
             */
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            if(from==null){
                messageHelper.setFrom(this.from); //设置默认账户发件人Email
            }else{
                messageHelper.setFrom(from); //设置发件人Email
            }
            messageHelper.setSubject(subject); //设置邮件主题
            messageHelper.setText("<html><head></head><body>"+content+"</body></html>",true);//设置邮件主题内容
            messageHelper.setTo(to);          //设定收件人Email
            mailSender.send(mimeMessage);
            logger.info(to+" 邮件已经发送。");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("发送邮件时发生异常！", e);
            return false;
        }
    }
}
