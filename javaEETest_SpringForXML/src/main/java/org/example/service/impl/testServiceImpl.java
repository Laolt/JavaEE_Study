package org.example.service.impl;

import org.example.dao.testDao;
import org.example.service.testService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
//InitializingBean初始化bean的接口,DisposableBean关闭bean的接口
public class testServiceImpl implements testService, InitializingBean, DisposableBean {
    private testDao testDao;
    //顺序：声明对象、构造方法、init()、setTestDao、afterPropertiesSet、destroy1、destroy()
    @Override
    public void b() {
        System.out.println("777");
        this.testDao.a();
    }
    void init(){
        System.out.println("init.");
    }
    void destroy1(){
        System.out.println("destroy.");
    }
    //提供对应的setter方法，容器会执行该方法
    public void setTestDao(testDao testDao) {
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
