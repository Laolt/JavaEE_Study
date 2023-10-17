package com.example;

import com.example.domain.properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

//配置三格式：
//1、application.properties（第一加载）
//server.port=80
//2、application.yml(第二加载，主要使用yml)
// 格式：
//server:
//  port:80
//enterprise:
// name:
//  -你好
//  -好
//3、application.yaml(第三加载)
//server:
//  port:80
@SpringBootApplication
public class JavaEeTestSpringBootTestApplication {
    //用注解读取对应配置文件的数据
    @Value("${server.port}")
    private Integer port;
    @Value("${enterprise.name[0]")
    private String a;
//    可以用来加载所有的环境信息,可任意通过这个对象调用getProperty方法获取配置信息里面的内容
    @Autowired
    private Environment e;
//    把配置信息加载到类中自动装配
    @Autowired
    private properties b;

    public static void main(String[] args) {
        SpringApplication.run(JavaEeTestSpringBootTestApplication.class, args);
    }

}
