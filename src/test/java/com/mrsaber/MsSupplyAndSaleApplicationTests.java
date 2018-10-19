package com.mrsaber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsSupplyAndSaleApplicationTests {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendTxtMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人
        simpleMailMessage.setTo(new String[]{"986836840@qq.com", "1873379225@qq.com"});
        simpleMailMessage.setFrom("mrsaber1997@163.com");
        simpleMailMessage.setSubject("Spring Boot Mail 邮件测试【文本】");
        simpleMailMessage.setText("这里是一段简单文本。");
        // 发送邮件
        mailSender.send(simpleMailMessage);

        System.out.println("邮件已发送");
    }


    @Test
    public void sendHtmlMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(new String[]{"986836840@qq.com", "1873379225@qq.com"});
        mimeMessageHelper.setFrom("mrsaber1997@163.com");
        mimeMessageHelper.setSubject("MS进销存系统数据库备份");

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>此邮件不需要回复</h1><p>在数据库遇到问题时需要用到此文件，每天都会自动备份，请不要加入黑名单</p></body>");
        sb.append("</html>");

        // 启用html
        mimeMessageHelper.setText(sb.toString(), true);
        FileSystemResource resource = new FileSystemResource("/Users/apple/IdeaProjects/bpfolder/2018-10-19-00.ms");
        // 发送邮件
        mimeMessageHelper.addAttachment("今日份数据",resource);
        mailSender.send(mimeMessage);
        System.out.println("邮件已发送");
    }


}
