package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {//资源的过滤类

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {//设置资源过滤规则(放行资源)
        //当访问到某一静态资源包staticPages时，对staticPages目录进行访问而不通过Mvc返回
        registry.addResourceHandler("/staticPages/**").addResourceLocations("/staticPages/");
    }
}
