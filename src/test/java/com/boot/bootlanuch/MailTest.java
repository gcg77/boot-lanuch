package com.boot.bootlanuch;

import com.boot.bootlanuch.model.vo.FriendVO;
import com.boot.bootlanuch.service.impl.MailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailTest {
    @Resource
    private MailService mailService;
    @Resource
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Test
    public void sendTextMail() {
        mailService.sendSimpleMail("759672969@qq.com", "Boot Lanuch Test", "去玩儿");
    }

    @Test
    public void sendHtmlMail() throws MessagingException {
        mailService.sendHtmlMail("759672969@qq.com", "Html Test", "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/boot-lanuch/file/upload/\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "    <input type=\"file\" name=\"uploadFile\" value=\"请选择上传文件\">\n" +
                "    <input type=\"submit\" value=\"保存\">\n" +
                "\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

    }
    @Test
    public void sendHtmlTempMail() throws MessagingException, IOException, TemplateException {
        List<FriendVO> friends=new ArrayList<>();
        friends.add(new FriendVO("gcg","11"));
        friends.add(new FriendVO("yy","12"));
        Template template=freeMarkerConfigurer.getConfiguration().getTemplate("mail-temp.html");
        Map<String,Object> model=new HashMap<>();
        model.put("friends",friends);
        String temp= FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
        mailService.sendHtmlMail("759672969@qq.com", "Html temp Test",temp);
    }
    @Test
    public void sendAttachmentMail() throws MessagingException, IOException, TemplateException {
        List<FriendVO> friends=new ArrayList<>();
        friends.add(new FriendVO("gcg","11"));
        friends.add(new FriendVO("yy","12"));
        Template template=freeMarkerConfigurer.getConfiguration().getTemplate("mail-temp.html");
        Map<String,Object> model=new HashMap<>();
        model.put("friends",friends);
        String temp= FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
        mailService.sendAttachmentMail("759672969@qq.com", "Html temp Test 带附件",temp,
                "F:"+ File.separator+"Document And Settings2"+ File.separator+"Administrator"+ File.separator+"Desktop"+ File.separator+"spark学习"+ File.separator+"spark学习.docx");
    }
    @Test
    public void sendResourceMail() throws MessagingException, IOException, TemplateException {
        String temp="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<img src=\'cid:"+"5888888"+"\'>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendResourceMail("759672969@qq.com", "Html temp Test 带内联附件",temp,
                "F:"+ File.separator+"Document And Settings2"
                        + File.separator+"Administrator"
                        + File.separator+"Desktop"
                        + File.separator+"spark学习"
                        + File.separator+"微信图片_20201219190616.jpg"
        ,"5888888");
    }
}
