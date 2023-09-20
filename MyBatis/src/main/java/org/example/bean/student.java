package org.example.bean;

public class student {
    int id;
    String name,major;

    public student() {
    }

    public student(int id) {
        this.id = id;
    }

    public student(String name) {
        this.name = name;
    }

    public student(String name, String major) {
        this.name = name;
        this.major = major;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
