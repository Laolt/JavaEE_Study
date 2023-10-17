package org.example.mapper;

import org.example.bean.course;
import org.example.bean.teacher;

import java.util.List;

public interface teacherAndClassMapper {
    List<course> selectTeacherByClass(course _class);
    List<teacher> selectClassByTeacher(teacher teacher);

}
