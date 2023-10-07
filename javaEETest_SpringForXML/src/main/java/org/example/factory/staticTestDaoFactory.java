package org.example.factory;

import org.example.dao.impl.testDaoImpl;
import org.example.dao.testDao;

public class staticTestDaoFactory {
    public static testDao getTestDao(){
        return new testDaoImpl();
    }
}
