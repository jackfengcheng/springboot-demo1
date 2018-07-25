package com.xwtech.demo.config;

import com.xwtech.demo.filter.DemoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *fc
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterDemo4Registration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new DemoFilter());
        //拦截规则
        registration.addUrlPatterns("/**");
        //过滤器名称
        registration.setName("UrlFilter");
        //是否自动注册 false 取消Filter的自动注册
        registration.setEnabled(false);
        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }
}
