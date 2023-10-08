package org.example.service;

import org.example.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//测试类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class testServiceTestWithJUnit {
    @Autowired
    private testServiceMFA testServiceMFA;
    @Test
    public void testSelectAll(){
        testServiceMFA.selectAll();
    }
}
