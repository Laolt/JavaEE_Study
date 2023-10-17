package com.example.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//用ConfigurationProperties注解将配置文件读取到类中
@Component
@ConfigurationProperties(prefix = "enterprise")
public class properties {
    private String[] B;
}
