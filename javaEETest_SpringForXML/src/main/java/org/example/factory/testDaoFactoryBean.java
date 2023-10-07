package org.example.factory;

import org.example.dao.impl.testDaoImpl;
import org.example.dao.testDao;
import org.springframework.beans.factory.FactoryBean;

public class testDaoFactoryBean implements FactoryBean<testDao> {
    //代替原始实例工厂中创建对象的方法
    @Override
    public testDao getObject() throws Exception {
        return new testDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return testDao.class;
    }
    //是否为单例
    @Override
    public boolean isSingleton() {
        //默认为true单例，false为非单例
        return FactoryBean.super.isSingleton();
    }
}
