package com.boot.bootlanuch.config;

import com.boot.bootlanuch.dao.master.UserTokenDao;
import com.boot.bootlanuch.entity.master.UserToken;
import com.boot.bootlanuch.entity.master.UserTokenExample;
import com.boot.bootlanuch.exception.BusinessException;
import com.boot.bootlanuch.service.UserService;
import com.boot.bootlanuch.utils.SpringContextUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author gcg
 * @WebFilter(filterName="customFilter",urlPatterns={"/*"})
 */
@Slf4j
public class CustomFilter implements Filter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        log.info("-----------------初始化filter-----------------");
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter 请求方法之前处理请求");
        chain.doFilter(request, response);


        log.info("doFilter 请求方法之后处理响应");
    }

    @Override
    public void destroy() {
        log.info("-----------------销毁filter-----------------");
    }
}
