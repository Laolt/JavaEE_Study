package org.example.bean;

import java.util.List;

public class teacher {
    int id;
    String name;
    //存储级联查询的课程集合
    List<Class> classList;
    public teacher() {
    }
    public List<Class> getClassList() {
        return classList;
    }
    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classList=" + classList +
                '}';
    }
}
