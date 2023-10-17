package com.example;

import com.example.dao.testDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaEeTestSpringBootAndMyBatisApplicationTests {
    @Autowired
    private testDao td;
    @Test
    void contextLoads() {
        System.out.println(td.selectAll());
    }

}
