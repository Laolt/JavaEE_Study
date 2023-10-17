package com.example.dao;

import com.example.domain.test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper//springBoot中的mybatis注解标注这是一个mapper配置文件
public interface testDao {
    @Select("select * from test")
    public List<test> selectAll();
}
