package org.example.domain;

public class test {
    String name,age;
    int id;

    @Override
    public String toString() {
        return "test{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
