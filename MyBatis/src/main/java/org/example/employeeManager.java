package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.bean.employee;
import org.example.mapper.employeeMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class employeeManager {
    SqlSession session;
    employeeMapper mapper;
    employee e;
    public employeeManager() throws IOException{
        InputStream input= Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);
        //构造函数配置sqlSession以及mappee代理
        this.session=sqlSessionFactory.openSession();
        this.mapper=session.getMapper(employeeMapper.class);
    }
    public void selectById(int id){
        //通过ID查询
        showMessgae(mapper.selectById(this.initEmployee(id,"null",-1,"null")));
    }

    public void addMessage(String name,int age,String position){
        //添加信息内容
        if(mapper.addMessage(this.initEmployee(-1,name,age,position))){
            session.commit();
            System.out.println("信息插入成功");
        }else {
            session.rollback();
            System.out.println("信息插入失败，请检查信息是否有误");
        }

    }
    public void setMessageById(int id,String name,int age,String position){
        //根据ID更改信息内容
        if(mapper.setMessage(this.initEmployee(id,name,age,position))){
            session.commit();
            System.out.println("信息修改成功");
        }else {
            session.rollback();
            System.out.println("信息修改失败，请检查信息是否有误");
        }
    }

    public void deleteMessageById(int id){
        //删除与ID对应的信息内容
        if(mapper.deleteMessage(this.initEmployee(id,"null",-1,"null"))){
            session.commit();
            System.out.println("id为"+id+"的信息删除成功");
        }else {
            session.rollback();
            System.out.println("信息删除失败，请检查信息是否存在");
        }
    }
    public employee initEmployee(int id,String name,int age,String position){
        //设置employee类的对象
        e=new employee();
        e.setId(id);
        e.setAge(age);
        e.setName(name);
        e.setPosition(position);
        return e;
    }
    public void showMessgae(List<employee> employees){
        //将所查询的信息展示，并在控制台输出出来
        for (org.example.bean.employee employee:employees){
            System.out.println("员工号："+employee.getId()+",员工姓名："+employee.getName()+",员工年龄："
                    +employee.getAge()+",员工职位："+employee.getPosition());
        }
    }
    public static void main(String []args) throws IOException {
        employeeManager e=new employeeManager();
        //查询id为2的数据
        e.selectById(2);
        //插入一条数据
        e.addMessage("赵六",56,"经理");
        //修改插入的数据
        e.setMessageById(4,"胡66",69,"总裁");
        //删除id为4的数据
       e.deleteMessageById(4);
    }
}
