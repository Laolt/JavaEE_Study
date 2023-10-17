package org.example;

import org.example.service.testService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
        testService ts=ctx.getBean("testService",testService.class);
        ts.selectAll();
    }
}