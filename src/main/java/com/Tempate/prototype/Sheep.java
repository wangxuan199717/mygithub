package com.Tempate.prototype;

public class Sheep {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sheep(String name, int age){
        this.age=age;
        this.name=name;
    }
}
