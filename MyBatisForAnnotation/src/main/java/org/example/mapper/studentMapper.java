package org.example.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.bean.student;

import java.util.List;

public interface studentMapper {
    List<student> select(student student);
    @Select("select * from student where id < #{id};")
    List<student> queryLessThanId(student student);
    List<student> selectById(List<student> studentList);
    @Insert("insert into student (name,major)values")
    Boolean insertMultiple(List<student> studentList);
}
