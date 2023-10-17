package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.bean.test;

import java.util.List;

public interface testMapper {
    List<test> selectAll();
    test selectOneById(int id);
    Boolean deleteDataById(@Param("id") int id);
    Boolean updateOneById(@Param("name") String name, @Param("id") int id, @Param("age") int age);
    Boolean insertOne(@Param("name") String name, @Param("age") int age);

}
