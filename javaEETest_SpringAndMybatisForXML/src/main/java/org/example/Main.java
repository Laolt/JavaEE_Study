package org.example;

import org.example.service.testService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        创建spring容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
//        获取service层的bean
        testService ts=ctx.getBean("testService",testService.class);
//        调用里面的方法
        ts.selectAll();
    }
}