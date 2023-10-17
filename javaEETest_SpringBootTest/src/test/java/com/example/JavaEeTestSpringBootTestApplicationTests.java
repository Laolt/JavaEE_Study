package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
//在测试类中会加载同层包下的所有含有@Component注解的文件作为springboot的bean
//只需要通过自动装配的方式将对应的bean装入并进行测试即可
// 关于@SpringBootTest注解如果测试类实在boot的启动类的包或者子包中可以省略启动类的设置即classes属性的配置
@SpringBootTest
class JavaEeTestSpringBootTestApplicationTests {

    @Test
    void contextLoads() {
    }

}
