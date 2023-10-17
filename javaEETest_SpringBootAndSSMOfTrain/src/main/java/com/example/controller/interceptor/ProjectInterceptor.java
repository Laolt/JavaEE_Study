package com.example.controller.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



//拦截器类,在SpringMvcSupport配置中注入拦截器，也可以直接写道SpringMvcConfig中
@Component
public class ProjectInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(1);
        //request请求体
        //response响应体
        //handler封装反射内部的对象封装了对应的方法，用作校验
        //返回false则终止原始操作的运行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(1);
        //modelAndView页面跳转
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(1);
//        ex异常
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
