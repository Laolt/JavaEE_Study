package org.example.factory;

import org.example1.dao.impl.testDaoImplFA;
import org.example1.dao.testDaoFA;
import org.springframework.beans.factory.FactoryBean;

public class testDaoFactoryBean implements FactoryBean<testDaoFA> {
    //代替原始实例工厂中创建对象的方法
    @Override
    public testDaoFA getObject() throws Exception {
        return new testDaoImplFA();
    }

    @Override
    public Class<?> getObjectType() {
        return testDaoFA.class;
    }
    //是否为单例
    @Override
    public boolean isSingleton() {
        //默认为true单例，false为非单例
        return FactoryBean.super.isSingleton();
    }
}
