package org.example.bean;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.testMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    private int id,age;
    private String name;
    private testjob job;

    public testjob getJob() {
        return job;
    }

    public void setJob(testjob job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", job=" + job +
                '}';
    }

    public test(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public test(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] orderTest) throws IOException {
        String resource = "MyBatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //test表中mapper代理的实例
        testMapper mapper=session.getMapper(testMapper.class);
        try{
            //查询所有
            List<test> t=mapper.selectAll();
            for (org.example.bean.test test : t) {
                System.out.println("ID=" + test.getId() + "姓名=" + test.getName() + "年龄=" + test.getAge());
            }
            //查询id为3的数据
            System.out.println(mapper.selectOneById(3));
            //删除id为3的数据,修改id为1的数据,插入一条名为“老头胡“的数据,
            if(mapper.deleteDataById(3)&&mapper.updateOneById("小胡",1,23)&&mapper.insertOne("老头胡",80)){
                session.commit();
                System.out.println("操作成功");
            }else {
                session.rollback();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}