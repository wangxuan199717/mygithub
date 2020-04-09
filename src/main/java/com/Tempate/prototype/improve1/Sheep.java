package com.Tempate.prototype.improve1;

import java.io.Serializable;

public class Sheep implements Cloneable , Serializable {
    private int age;
    private String name;
    public Sheep friend;

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

    @Override
    public String toString() {
        return "Sheep{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        Sheep sheep = null;
        Sheep sheep1 = null;
        try {
            if(friend!=null)
                sheep1 = (Sheep) friend.clone();
            sheep = (Sheep) super.clone();
            sheep.friend = sheep1;
        }catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
