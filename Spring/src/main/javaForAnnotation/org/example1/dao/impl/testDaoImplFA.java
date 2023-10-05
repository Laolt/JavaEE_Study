package org.example1.dao.impl;

import org.example1.dao.testDaoFA;
import org.springframework.stereotype.Component;

@Component
public class testDaoImplFA implements testDaoFA {
    @Override
    public void a() {
        System.out.println("666");
    }
}
