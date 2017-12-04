package com.lab.config;

import com.lab.interceptor.AuthorityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by elotoma on 2017/12/1.
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 加入检验权限的拦截器
        registry.addInterceptor(new AuthorityInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }
}
