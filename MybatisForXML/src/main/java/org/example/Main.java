package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.testMapper;
import org.example.utils.MyBatisUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSession session= MyBatisUtil.getSqlSession();
       System.out.println(session.selectList("selectAll"));
//        testMapper testMapper=session.getMapper(org.example.mapper.testMapper.class);
//        System.out.println(testMapper.selectAll());
        System.out.println("测试");
    }

}