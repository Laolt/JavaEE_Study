package org.example.service;

import org.example.dao.testDao;

public class testService {
    testDao td;

    public void setTd(testDao td) {
        this.td = td;
    }

    public void selectAll(){
        System.out.println(td.selectAll());
    }
}
