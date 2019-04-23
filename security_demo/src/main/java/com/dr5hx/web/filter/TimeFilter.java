package com.dr5hx.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig)  {
        System.out.println("初始化filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long l = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter其所耗时：" + (new Date().getTime() - l));
    }

    @Override
    public void destroy() {
        System.out.println("结束filter");
    }
}
