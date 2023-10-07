package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:database.properties")//加载外部文件同样用${}进行引用,不支持*
public class SpringConfig {
}