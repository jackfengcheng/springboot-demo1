package com.xwtech.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String Sender;

//    private String Resver = "2515736155@qq.com";
    @RequestMapping(value = "/sendSimpleMail",method =GET, produces = "application/json")
    public void sendSimpleMail(String Resver) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);

        message.setTo(Resver); //自己给自己发送邮件
//        message.setTo(Sender); //自己给自己发送邮件
        message.setSubject("我爱你");
        message.setText("我爱你，宝贝");

        for (int i = 0; i < 1000; i++) {
            mailSender.send(message);
            log.info(Sender + "给" + Resver +"邮件发送成功" + "第"+i+"次");
        }


    }

    @RequestMapping(value = "/sendHtmlMail",method =GET, produces = "application/json")
    public void sendHtmlMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo(Sender);
            helper.setSubject("标题：发送Html内容");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("邮件发送成功");
        mailSender.send(message);
    }

    @RequestMapping(value = "/sendAttachmentsMail",method =GET, produces = "application/json")
    public void sendAttachmentsMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo(Sender);
            helper.setSubject("主题：带附件的邮件");
            helper.setText("带附件的邮件内容");
            //注意项目路径问题，自动补用项目路径
            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/picture.jpg"));
            //加入邮件
            helper.addAttachment("图片.jpg", file);
        } catch (Exception e){
            e.printStackTrace();
        }
        log.info("邮件发送成功");
        mailSender.send(message);
    }

}
