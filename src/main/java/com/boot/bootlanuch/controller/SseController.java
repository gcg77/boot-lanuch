package com.boot.bootlanuch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author admin
 */
@RestController
public class SseController {
    @RequestMapping(value = "/sse/push", produces = "text/event-stream;charset=UTF-8")
    public String push(HttpServletResponse res) {
        res.setHeader("Access-Control-Allow-Origin", "*");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String nowDate = sdf.format(date);
        return "data: 我是一个data 现在时间是" + nowDate + " \nevent:like\n retry:5000\n\n";

    }
}
