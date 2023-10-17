package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.bean.employee;

import java.util.List;

public interface employeeMapper {
    @Select("SELECT * FROM employee WHERE id=#{id}")
    List<employee> selectById(employee e);
    @Insert("INSERT INTO employee (name,age,position)VALUES(#{name},#{age},#{position})")
    Boolean addMessage(employee e);
    @Update("UPDATE employee SET name=#{name},age=#{age},position=#{position} WHERE id=#{id}")
    Boolean setMessage(employee e);
    @Delete("DELETE FROM employee WHERE id=#{id}")
    Boolean deleteMessage(employee e);
}
