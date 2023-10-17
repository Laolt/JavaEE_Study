package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.bean.test;
import org.example.mapper.testForAnnotation;
import org.example.utils.MyBatisUtil;

import java.io.IOException;

public class testForAnnotationManager {
    private final testForAnnotation mapper;
    testForAnnotationManager() throws IOException {
        SqlSession session = MyBatisUtil.getSqlSession();
        this.mapper= session.getMapper(testForAnnotation.class);
    }
    public void selectOneOnOneById(int id){
        showMessage(mapper.selectTestWithJobById(id));
    }
    public void showMessage(test t){
        System.out.println("你所查询的信息id为"
                +t.getId()+"姓名为："
                +t.getName()+"年龄为："
                +t.getAge()+"职业是："
                +t.getJob().getJobName());
    }
    public static void main(String[] args) throws IOException {
        new testForAnnotationManager().selectOneOnOneById(2);
    }
}
