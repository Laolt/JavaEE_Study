package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.config.SpringConfig;
import org.example.dao.testDaoMFA;
import org.example.service.testServiceMFA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        ac.getBean(testServiceMFA.class).selectAll();
    }
}