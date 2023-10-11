package org.example.dao.impl;

import org.example.dao.testDaoOfAOPFA;
import org.springframework.stereotype.Repository;

@Repository
public class testDaoOfAOPImplFA implements testDaoOfAOPFA {

    @Override
    public int save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("save");
        int a=100;
        System.out.println(a);
        return a;
    }

    @Override
    public void update() {
        System.out.println("update");
    }
}
