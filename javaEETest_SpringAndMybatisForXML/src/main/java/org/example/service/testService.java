package org.example.service;

import org.example.mapper.testMapper;

public class testService {
    testMapper tm;

    public void setTd(testMapper td) {
        this.tm = td;
    }

    public void selectAll(){
        System.out.println(tm.selectAll());
    }
}
