package org.example.bean;

public class employee {
    int id,age;
    String name,position;

    public employee() {
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
