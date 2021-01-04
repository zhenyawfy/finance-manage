package com.demo.config;

import com.demo.interceptor.TestInterceptor;
import com.demo.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()) .addPathPatterns("/test/**").excludePathPatterns("/**");
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/**/userLogin","/**/error");
    }
}
