package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.studentMapper;
import org.example.bean.student;
import org.example.utils.MyBatisUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class studentsManager {
    SqlSession session;
    studentMapper mapper;
    student s;
    public studentsManager()throws IOException{
        //获取SqlSession对象
        this.session = MyBatisUtil.getSqlSession();
        //test表中mapper代理的实例
        this.mapper=session.getMapper(studentMapper.class);
    }
    public student initStudent(int id,String name,String major){
        s=new student();
        s.setId(id);
        s.setName(name);
        s.setMajor(major);
        return s;
    }
    public void showMessage(List<student> students){
        System.out.println("查询到的学生信息如下：");
        for(org.example.bean.student student:students){
            System.out.println("学号："+student.getId()+"姓名："+student.getName()+"专业："+student.getMajor());
        }
    }
    public void mutiConditionSelect(int id,String name,String major){
        showMessage(mapper.select(initStudent(id,name,major)));
    }
    public void queryLessThanId(int id,String name,String major){
        showMessage(mapper.queryLessThanId(initStudent(id,name,major)));
    }
    public void selectById(int []idList){
        List<student> studentList=new ArrayList<>();
        for (int id:idList){
            s=new student();
            s.setId(id);
            studentList.add(s);
        }
        showMessage(mapper.selectById(studentList));
    }
    public void insertMoreMessage(List<student> studentList){
        if(mapper.insertMultiple(studentList)){
            session.commit();
            System.out.println(studentList.size()+"条信息插入成功");
        }else {
            session.rollback();
            System.out.println(studentList.size()+"条信息插入失败，请检查信息是否有误。");
        }
    }
    public static void main(String []args) throws IOException {
        studentsManager SM=new studentsManager();
        //1、多条件查询
        //（1）姓名不为空，则按照姓名查询
        SM.mutiConditionSelect(3,"D","软件工程");
        //(2)姓名为空专业不为空则按专业查询
        SM.mutiConditionSelect(3,null,"软件工程");
        //(3)姓名和专业都为空则根据学号进行查询
        SM.mutiConditionSelect(3,null,null);
        //2、查询出所以ID值小于5的学生信息
        SM.queryLessThanId(5,null,null);
        //3、查询ID为1、3、5的学生信息
        SM.selectById(new int[]{1, 3, 5});
        //4、插入多条数据
        List<student> studentList=new ArrayList<>();
        studentList.add(SM.initStudent(6,"gg","人工智能"));
        studentList.add(SM.initStudent(7,"hh","土木工程"));
        studentList.add(SM.initStudent(8,"tt","金融管理"));
        SM.insertMoreMessage(studentList);
    }
}
