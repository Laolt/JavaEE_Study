package org.example.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
//mybatis配置类文件配置mybatis
public class MyBatisConfig {
//    配置SqlSessionFactory
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
//        指定pojo文件所在的包
        ssfb.setTypeAliasesPackage("org.example.domain");
//        设置数据源
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

//    配置mapper映射文件
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc=new MapperScannerConfigurer();
//        指定mapper所在的包
        msc.setBasePackage("org.example.dao");
        return msc;
    }
}
