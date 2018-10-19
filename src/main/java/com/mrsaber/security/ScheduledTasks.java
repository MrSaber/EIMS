package com.mrsaber.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Component
public class ScheduledTasks {
    @Autowired
    private JavaMailSenderImpl mailSender;

    //定时备份数据
    @Scheduled(cron = "0 0 22 * * *")
    public void BackUpDD()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-ss");
        String fileName = format.format(new Date())+".ms";

        try {
            MySQLDatabaseBackUp.exportDatabaseTool("127.0.0.1","root","123456","../bpfolder",fileName,"gongxiao");
            sendHtmlMail("../bpfolder/"+fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendHtmlMail(String filePath) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(new String[]{"986836840@qq.com", "119235030@qq.com"});
        mimeMessageHelper.setFrom("mrsaber1997@163.com");
        mimeMessageHelper.setSubject("MS进销存系统数据库备份");

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>此邮件不需要回复</h1><p>在数据库遇到问题时需要用到此文件，每天都会自动备份，请不要加入黑名单</p></body>");
        sb.append("</html>");

        // 启用html
        mimeMessageHelper.setText(sb.toString(), true);
        FileSystemResource resource = new FileSystemResource(filePath);
        // 发送邮件
        mimeMessageHelper.addAttachment("今日份数据",resource);
        mailSender.send(mimeMessage);
        System.out.println("邮件已发送");
    }


}
