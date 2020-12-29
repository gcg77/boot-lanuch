package com.boot.bootlanuch;

import gui.ava.html.image.generator.HtmlImageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DeskTopTest {
    @Test
    public void urlFileTest() throws FileNotFoundException {
        URL url = null;
        try {
            url = new URL("https://github.com/gcg77/boot-lanuch");   //想要读取的url地址
            File fp = new File("D:/agriculture/test.html");
            OutputStream os = new FileOutputStream(fp);          //建立文件输出流
            URLConnection conn = url.openConnection();          //打开url连接
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String urlString = "";
            String current;
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
            os.write(urlString.getBytes());
            os.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UrlToPng() throws FileNotFoundException {
            try {
                // 文件的路径
                String src = "D:/agriculture/echarts.html";
                File file = new File(src);
                String htmlTemplate = FileUtils.readFileToString(file, "utf-8");
                HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
                //加载html模版
                imageGenerator.loadHtml(htmlTemplate);
                //把html写入到图片
                imageGenerator.saveAsImage("D:/agriculture/test.png");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}