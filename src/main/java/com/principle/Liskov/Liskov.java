package com.principle.Liskov;


//里式替换原则：类的继承应当遵守的原则，最好不要重写父类的方法
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3="+a.minus(11,3));

        B b = new B();
        System.out.println("11-3="+b.minus(11,3));
    }
}
class A{
    public int minus(int a,int b){
        return a-b;
    }
}
class B extends A{
    //无意中重写了minus
    public int minus(int a,int b){
        return a+b;
    }
    public int add9(int a,int b){
        return minus(a,b)+9;
    }
}
