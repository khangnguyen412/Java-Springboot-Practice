package com.example.JavaSpingBootPractice.interceptor;

import jakarta.servlet.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.*;

@Component
public class Lecture3CustommerInterceptor implements HandlerInterceptor {
     // Chạy TRƯỚC khi vào Controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("[preHandle] Request URL: " + request.getRequestURL());
        return true;
    }

    // Chạy SAU khi controller xử lý nhưng TRƯỚC khi trả về response
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("[postHandle] Request URL: " + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("[afterCompletion] Request URL: " + request.getRequestURL());
    }

}
