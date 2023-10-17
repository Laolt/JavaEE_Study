package org.example.mapper;
import org.apache.ibatis.annotations.Select;
import org.example.bean.student;

import java.util.List;

public interface studentMapper {
    List<student> select(student student);

    List<student> queryLessThanId(student student);
    List<student> selectById(List<student> studentList);
    Boolean insertMultiple(List<student> studentList);
}
