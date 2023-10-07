package org.example.dao.impl;

import org.example.dao.testDaoFA;
import org.springframework.stereotype.Component;

@Component
public class testDaoImplFA implements testDaoFA {
    @Override
    public void a() {
        System.out.println("666");
    }
}
