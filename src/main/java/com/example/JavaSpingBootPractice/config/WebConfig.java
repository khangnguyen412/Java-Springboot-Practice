package com.example.JavaSpingBootPractice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

import com.example.JavaSpingBootPractice.interceptor.Lecture3CustommerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Lecture3CustommerInterceptor lecture3_custommer_interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(lecture3_custommer_interceptor)
                .addPathPatterns("/lecture2/api/customer/**") // Áp dụng cho tất cả các API trong lecture3
                .excludePathPatterns("/lecture2/api/account/**"); // Bỏ qua các API trong lecture2
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
