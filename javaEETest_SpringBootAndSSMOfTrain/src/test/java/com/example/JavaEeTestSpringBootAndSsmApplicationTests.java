package com.example;

import com.example.service.impl.trainServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaEeTestSpringBootAndSsmApplicationTests {
    @Autowired
    private trainServiceImpl tsi;
    @Test
    void contextLoads() {
        System.out.println( tsi.selectAll(0));
    }

}
