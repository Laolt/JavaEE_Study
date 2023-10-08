package org.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
//数据源文件配置
public class DatabaseConfig {
//    通过成员变量获取加载的文件里面对应的值
    @Value("${className}")
    private String className;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;
//    配置数据源文件
    @Bean
    public DataSource dataSource(){
        DruidDataSource ds=new DruidDataSource();
        ds.setUsername(username);
        ds.setUrl(url);
        ds.setPassword(password);
        ds.setDriverClassName(className);
        return ds;
    }
}
