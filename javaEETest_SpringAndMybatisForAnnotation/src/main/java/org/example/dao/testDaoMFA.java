package org.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.domain.test;

import java.util.List;

public interface testDaoMFA {
    @Select("SELECT * FROM test WHERE id=#{id}")
    List<test> selectById(int id);
    @Select("SELECT * FROM test")
    List<test> selectAll();
    @Update("UPDATE test SET name=#{name},age=#{age} WHERE id=#{id}")
    Boolean updateById(test t);
    @Insert("INSERT INTO test(name,age)VALUES(#{name},#{age})")
    Boolean insertData(test t);
    @Delete("DELETE FROM test WHERE id=#{id}")
    Boolean deleteById(int id);
}
