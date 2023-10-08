package org.example;

import org.example.config.SpringConfig;
import org.example.service.testServiceMFA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class testSpringAndMybatisForAnnotation {
    public static void main(String[] args){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        ac.getBean(testServiceMFA.class).selectAll();
    }
}