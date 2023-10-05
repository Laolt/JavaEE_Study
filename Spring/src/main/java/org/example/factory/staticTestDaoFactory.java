package org.example.factory;

import org.example1.dao.impl.testDaoImplFA;
import org.example1.dao.testDaoFA;

public class staticTestDaoFactory {
    public static testDaoFA getTestDao(){
        return new testDaoImplFA();
    }
}
