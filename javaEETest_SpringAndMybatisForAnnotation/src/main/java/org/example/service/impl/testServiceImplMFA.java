package org.example.service.impl;

import org.example.dao.testDaoMFA;
import org.example.domain.test;
import org.example.service.testServiceMFA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testServiceImplMFA implements testServiceMFA {
    @Autowired
    testDaoMFA tDao;
    @Override
    public void selectById(int id) {
        show(tDao.selectById(id));
    }

    @Override
    public void selectAll() {
        show(tDao.selectAll());
    }

    @Override
    public void deleteById(int id) {
        tDao.deleteById(id);
    }

    @Override
    public void updateById(test t) {
        tDao.updateById(t);
    }

    @Override
    public void insert(test t) {
        tDao.insertData(t);
    }
    void show(List<test> testList){
        for (test test:testList){
            System.out.println("id:"+test.getId()+"Name"+test.getName()+"Age:"+test.getAge());
        }
    }
}
