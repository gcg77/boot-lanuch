package com.boot.bootlanuch.config;

import com.boot.bootlanuch.exception.BusinessException;
import com.boot.bootlanuch.service.UserService;
import com.boot.bootlanuch.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */
@Component
@Slf4j
public class CustomerHandler implements HandlerInterceptor {
    @Resource
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info("请求前调用");
        request.setCharacterEncoding("utf-8");
        log.info(request.getRemoteAddr());
        String userid = request.getHeader("userid");
        String token = request.getHeader("token");
        log.info("----------------userid----------------:" + userid);
        log.info("----------------token----------------:" + token);
        if (StringUtils.isBlank(userid)) {
            throw new BusinessException("用户id不能为空");
        } else {
            if (StringUtils.isBlank(token)) {
                throw new BusinessException("用户token不能为空");
            } else {
                String userToken=userService.getToken(Integer.valueOf(userid));
                log.info("----------------userToken----------------:" + userToken);
                if (!token.equals(userToken)) {
                    throw new BusinessException("用户用户token不一致");
                }
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("请求后调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("请求完成后回调方法");
    }
}
