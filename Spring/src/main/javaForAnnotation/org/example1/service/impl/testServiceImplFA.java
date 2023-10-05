package org.example1.service.impl;

import org.example1.dao.testDaoFA;
import org.example1.service.testServiceFA;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


//InitializingBean初始化bean的接口,DisposableBean关闭bean的接口
@Component("testServiceFA")

//@Scope("prototype")设置为非单例
public class testServiceImplFA implements testServiceFA, InitializingBean, DisposableBean {
    @Autowired//按类型自动装配，多同类型时按名称自动装配或者加上@Qualifier("")指定名称按名称装配，可以不用setter方法

    private testDaoFA testDao;
    @Value("${password}")//装配简单类型
    private int a;
    //顺序：声明对象、构造方法、init()、setTestDao、afterPropertiesSet、destroy1、destroy()
    @Override
    public void b() {
        System.out.println("777"+a);
        this.testDao.a();
    }
    @PostConstruct//相当于afterPropertiesSet

    void init(){
        System.out.println("init.");
    }
    @PreDestroy//相当于destroy
    void destroy1(){
        System.out.println("destroy.");
    }
    //提供对应的setter方法，容器会执行该方法
    public void setTestDao(testDaoFA testDao) {
        this.testDao = testDao;
    }
    //创建方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init.");
    }
    //关闭方法
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy.");
    }
}
