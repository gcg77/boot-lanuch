package com.boot.bootlanuch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
/**
 * @Author gcg
 */
public class ListenerController {
    @GetMapping("/hellow")
    public String Listen(HttpServletRequest request, HttpSession session){
        request.setAttribute("a","1");
        request.setAttribute("a","2");
        request.getAttribute("a");
        request.removeAttribute("a");
        session.setAttribute("b","1");
        session.getAttribute("b");
        session.invalidate();
        return "Listen";
    }
}
