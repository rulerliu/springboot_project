package com.liuwq.demo.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {

    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("/user/login");
        list.add("/user/register");
        registry.addInterceptor(myInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns(list);
    }
    
    
}