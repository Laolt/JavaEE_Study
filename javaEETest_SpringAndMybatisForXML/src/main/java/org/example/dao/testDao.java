package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.domain.test;

import java.util.List;

public interface testDao {
    @Select("select * from test")
    List<test> selectAll();
}
