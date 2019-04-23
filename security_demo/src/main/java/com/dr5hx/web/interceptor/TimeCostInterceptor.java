package com.dr5hx.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class TimeCostInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("开始拦截");
        HandlerMethod o1 = (HandlerMethod) o;
        String name = o1.getBean().getClass().getName();
        System.out.println("className:" + name);
        String name1 = o1.getMethod().getName();
        System.out.println("methodName:" + name1);
        long l = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        httpServletRequest.setAttribute("startTime", l);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long l = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("拦截器所耗时为：" + (l - startTime));
    }
}
