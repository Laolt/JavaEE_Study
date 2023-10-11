package org.example.mapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.bean.Class;
import org.example.bean.teacher;
import java.util.List;

public interface teacherAndClassMapper {
    List<Class> selectTeacherByClass(Class _class);
    List<teacher> selectClassByTeacher(teacher teacher);
    @Select("select * from teacher where id =#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "classList",column = "id" ,many=@Many(select ="selectClassByTeacherIdForAnnotation" ))
    })
    List<teacher> selectClassByTeacherForAnnotation(teacher teacher);
    @Select("select * from class where id in(select class_id from teacher_class where teacher_id=#{id});")
    Class selectClassByTeacherIdForAnnotation();
    @Select("select * from class where id =#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "teachersList",column = "id", many=@Many(select = "selectTeacherByClassIdForAnnotation"))
    })
    List<Class> selectTeacherByClassForAnnotation(Class _class);
    @Select("select * from teacher where id in(select teacher_id from teacher_class where class_id=#{id});")
    teacher selectTeacherByClassIdForAnnotation();

}
