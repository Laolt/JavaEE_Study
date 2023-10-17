package org.example.bean;

import java.util.List;

public class course {
    int id;
    String name;
    //存储级联查询到的教师集合
    List<teacher> teachersList;
    public course() {
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

    public List<teacher> getTeachersList() {
        return teachersList;
    }

    public void setTeachersList(List<teacher> teachersList) {
        this.teachersList = teachersList;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachersList=" + teachersList +
                '}';
    }
}
