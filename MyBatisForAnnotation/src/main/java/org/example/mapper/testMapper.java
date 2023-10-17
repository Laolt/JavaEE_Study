package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.bean.test;
import java.util.List;

public interface testMapper {
    @Select("select * from test")
    List<test> selectAll();
    @Select("select * from test WHERE id=#{id}")
    test selectOneById(int id);
    @Delete("DELETE FROM test WHERE id=#{id};")
    Boolean deleteDataById(@Param("id")int id);
    @Update("UPDATE test SET name=#{name},age=#{age} WHERE id=#{id}")
    Boolean updateOneById(@Param("name")String name, @Param("id")int id,@Param("age")int age);
    @Insert("INSERT INTO test (name,age)VALUES(#{name},#{age})")
    Boolean insertOne(@Param("name")String name,@Param("age")int age);

}
