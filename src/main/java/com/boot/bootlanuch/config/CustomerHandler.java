package com.boot.bootlanuch.config;

import com.boot.bootlanuch.entity.master.UserToken;
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
import java.text.SimpleDateFormat;

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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        request.setCharacterEncoding("utf-8");
        String url=request.getRequestURI().toString();
        if(url.contains("/boot-lanuch/userlogin")){
          return true;
        }
         String userid = request.getHeader("userid");
        String token = request.getHeader("token");
        UserToken userToken=userService.userToken(token);
        if(userToken!=null){
            if(df.parse(userToken.getFailure_date()).getTime()<System.currentTimeMillis()){
                throw new BusinessException("token失效，请重新登录");
            }
            if(StringUtils.isNotBlank(userid)&& userid.equals(userToken.getUserid())){
                return true;
            }
        }
        throw new BusinessException("登录失败，请重新登录");
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
