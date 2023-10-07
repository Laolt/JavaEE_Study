package org.example;

import org.example1.dao.testDaoFA;
import org.example1.service.testServiceFA;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testApp {
    public static void main(String[] args) {
        //获取IOC容器
        //ApplicationContext tac=new ClassPathXmlApplicationContext("testAppContext.xml.test");
        ClassPathXmlApplicationContext tac=new ClassPathXmlApplicationContext("testAppContext.xml");
        //获取bean
        //直接关闭容器tac.close();
        //registerShutdownHook()设置关闭钩子使得虚拟机关闭之前关闭容器
        //两方法都来自于ConfigurableApplicationContext接口
        tac.registerShutdownHook();
        testDaoFA testDao=tac.getBean("testDaoFactoryBean", testDaoFA.class);
        testDao.a();
        testServiceFA testService=(testServiceFA) tac.getBean("testService");
        testService.b();
    }
}