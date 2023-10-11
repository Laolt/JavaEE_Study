package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//创建配置类，加载controller对应的Bean
@Configuration
@ComponentScan("org.example.controller")
public class SpringMvcConfig {
}
