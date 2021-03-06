package com.dr5hx.web.config;

import com.dr5hx.web.filter.TimeFilter;
import com.dr5hx.web.interceptor.TimeCostInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private TimeCostInterceptor timeCostInterceptor;

    //    @Bean
    public FilterRegistrationBean getTimeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new TimeFilter());
        List<String> strings = new ArrayList<String>();
        strings.add("/*");
        filterRegistrationBean.setUrlPatterns(strings);
        return filterRegistrationBean;
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeCostInterceptor);
//    }


}
