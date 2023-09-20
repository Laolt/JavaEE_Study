package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.studentMapper;
import org.example.mapper.testMapper;
import org.example.bean.student;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String []args) throws IOException {
        String resource = "MyBatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //test表中mapper代理的实例
        studentMapper mapper=session.getMapper(studentMapper.class);
        //有姓名按姓名查询
        for (org.example.bean.student student: mapper.select(new student("D",null))){
            System.out.println("按姓名查询");
            System.out.println("学号："+student.getId()+"姓名"+student.getName()+"专业"+student.getMajor());
        }
        //无姓名按专业
        for (org.example.bean.student student: mapper.select(new student(null,"软件工程"))){
            System.out.println("姓名为空按专业查询");
            System.out.println("学号："+student.getId()+"姓名"+student.getName()+"专业"+student.getMajor());
        }
        //无姓名无专业则将所有学号不为空的信息查询出来
        System.out.println("姓名专业为空，查询所有学号不为空的信息");
        for (org.example.bean.student student: mapper.select(new student(null,null))){
            System.out.println("学号："+student.getId()+"姓名"+student.getName()+"专业"+student.getMajor());
        }
        //查询学号小于5的学生信息
        System.out.println("查询小于学号5的学生信息");
        for (org.example.bean.student student: mapper.selectM()){
            System.out.println("学号："+student.getId()+"姓名"+student.getName()+"专业"+student.getMajor());
        }
        //查询学号为1、3、5的学生信息
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        map.put("p1",1);
        map.put("p2",3);
        map.put("p3",5);
        map1.put("hmap",map);
        System.out.println("查询出学号为1、3、5的学生");
        for (org.example.bean.student student: mapper.selectMore(map1)){
            System.out.println("学号："+student.getId()+"姓名"+student.getName()+"专业"+student.getMajor());
        }
        //插入多条学生信息
        Map<String,Object> studentmap=new HashMap<>();
        Map<String,Object> hashMap=new HashMap<>();
        studentmap.put("sthdent1",new student("aa","金融管理"));
        studentmap.put("sthdent2",new student("bb","视觉传达"));
        studentmap.put("sthdent3",new student("cc","虚拟现实应用"));
        hashMap.put("insertmap",studentmap);
        if (mapper.insertMore(hashMap)){
            session.commit();
            System.out.println("三条数据插入成功");
        }else{
            session.rollback();
            System.out.println("插入失败");
        }

    }
}
