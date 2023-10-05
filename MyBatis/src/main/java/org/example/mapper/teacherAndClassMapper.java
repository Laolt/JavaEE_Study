package org.example.mapper;
import org.example.bean.Class;
import org.example.bean.teacher;
import java.util.List;

public interface teacherAndClassMapper {
    List<Class> selectTeacherByClass(Class _class);
    List<teacher> selectClassByTeacher(teacher teacher);

}
