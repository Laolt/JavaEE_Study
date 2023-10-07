package org.example.factory;

import org.example.dao.impl.testDaoImpl;
import org.example.dao.testDao;

public class testDaoFactory {
    public testDao getTestDao(){
        return new testDaoImpl();
    }
}
