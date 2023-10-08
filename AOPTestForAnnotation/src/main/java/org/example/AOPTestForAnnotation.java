package org.example;

import org.example.config.SpringConfig;
import org.example.dao.testDaoOfAOPFA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTestForAnnotation {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        testDaoOfAOPFA t=applicationContext.getBean(testDaoOfAOPFA.class);
        System.out.println(t.save());
    }
}