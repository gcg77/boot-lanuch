package com.boot.bootlanuch.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author gcg
 */
@Slf4j
@WebListener
public class CustomListener implements ServletContextListener,
        ServletRequestListener,
        HttpSessionListener,
        ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("创建ServletContext");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("销毁ServletContext");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("添加Attribute");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("删除Attribute");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("替换Attribute");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("销毁ServletRequest");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("创建ServletRequest");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("创建Session");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("销毁Session");
    }
}
