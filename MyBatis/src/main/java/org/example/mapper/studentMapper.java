package org.example.mapper;
import org.example.bean.student;

import java.util.List;
import java.util.Map;

public interface studentMapper {
    List<student> select(student a);
    List<student> selectM();
    List<student> selectMore(Map<String,Object> map );
    Boolean insertMore(Map<String,Object> map);
}
