package com.leetcode;


import java.io.*;

class Person implements Serializable {
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
}
public class Serial {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setAge(10);
        person.setName("wang");
        ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream("f://test")));
        oos.writeObject(person);
        oos.close();

        person.setName("zhang");
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("f://test"));
        Person person1 = (Person)oin.readObject();
        System.out.println(person1.getName());
    }
}
