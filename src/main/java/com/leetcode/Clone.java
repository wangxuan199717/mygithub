package com.leetcode;

import java.io.*;

public class Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setAge(10);
        Student student1 = student;
        System.out.println(student.getAge()+":"+student1.getAge());
        student.setAge(13);
        System.out.println(student.getAge()+":"+student1.getAge());
        Student student2 = (Student) student.clone();
        student.setAge(15);
        System.out.println(student.getAge()+":"+student1.getAge()+":"+student2.getAge());
    }
}

class Student implements Cloneable,Serializable{
    private int age;
    private teacher t;

    public int getAge() {
        return age;
    }

    public teacher getT() {
        return t;
    }

    public void setT(teacher t) {
        this.t = t;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student result = null;
        result = (Student) super.clone();
        result.setT(new teacher());
        return result;
    }

    public Object myclone(){
        teacher t = null;
        try { // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            t = (teacher) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
}
class teacher implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
