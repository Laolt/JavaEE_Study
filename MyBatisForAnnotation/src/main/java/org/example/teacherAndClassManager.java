package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.bean.course;
import org.example.bean.teacher;
import org.example.mapper.teacherAndClassMapper;
import org.example.utils.MyBatisUtil;

import java.io.IOException;
import java.util.List;

public class teacherAndClassManager {
    SqlSession session;
    teacherAndClassMapper mapper;
    course _class;
    teacher teacher;
    public teacherAndClassManager() throws IOException {//获取mapper代理
        session= MyBatisUtil.getSqlSession();
        mapper= session.getMapper(teacherAndClassMapper.class);
    }
    void selectTeacherByClass(int id){//执行接口函数并展示对应结果
        _class=new course();
        _class.setId(id);
//        showMessageOfClass(mapper.selectTeacherByClass(_class));
        showMessageOfClass(mapper.selectTeacherByClassForAnnotation(_class));
    }
    void selectClassByTeacher(int id) {//执行接口函数并展示对应结果
        teacher = new teacher();
        teacher.setId(id);
//        showMessageOfTeacher(mapper.selectClassByTeacher(teacher));
        showMessageOfTeacher(mapper.selectClassByTeacherForAnnotation(teacher));
    }
    public void showMessageOfTeacher(List<teacher> teachers){//展示对应老师的所有课程信息
        System.out.println("id为"+teachers.get(0).getId()+"的老师是"+teachers.get(0).getName()+"老师，该老师教的课程有：");
        for (course _class: teachers.get(0).getClassList()){
            System.out.println(_class.getName());
        }
    }
    public void showMessageOfClass(List<course> classes){//展示对应课程的所有老师信息
       System.out.println("id为："+classes.get(0).getId()+"的课程是："+classes.get(0).getName()+",该课程由以下老师教授：");
       for (teacher teacher1: classes.get(0).getTeachersList()){
           System.out.println(teacher1.getName()+"老师");
        }
    }
    public static void main(String[] args) throws IOException {
        teacherAndClassManager manager=new teacherAndClassManager();
        //查询课程id为3的所有任教该课程的教师信息
        System.out.println("根据课程编号查询任教该课程的所有教师信息");
        manager.selectTeacherByClass(3);
        //查询教师id为3的所有所教授课程的信息
        System.out.println("根据教师编号查询该教师任教所有课程的信息");
        manager.selectClassByTeacher(3);
    }
}
