package com.Tempate.prototype.improve;

public class Sheep implements Cloneable{
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
    @Override
    protected Object clone() {
        try {
            Sheep sheep = null;
            sheep = (Sheep) super.clone();
            return sheep;
        }catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }
}
