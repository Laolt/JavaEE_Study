package org.example.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("org.example.domain");
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer getMapper(){
        MapperScannerConfigurer msc=new MapperScannerConfigurer();
        msc.setBasePackage("org.example.dao");
        return msc;
    }

}
