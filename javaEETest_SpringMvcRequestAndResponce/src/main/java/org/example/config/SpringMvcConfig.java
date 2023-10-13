package org.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"org.example.controller","org.example.config"})
@EnableWebMvc//功能：1、通过converter接口进行日期格式的的匹配转换，
			//2、通过Http2Jackson2MessageConverter接口使得pojo以及JSON数据之间可以相互转换
public class SpringMvcConfig {
    public SpringMvcConfig() {
    }
}
