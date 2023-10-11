package org.example.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//定义一个servlet的容器启动类加载spring的配置
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
//    加载SpringMvc容器配置
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext wctx=new AnnotationConfigWebApplicationContext();
        wctx.register(SpringMvcConfig.class);
        return wctx;
    }
//    设置那些请求归属springMvc处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
//    加载spring容器配置
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
