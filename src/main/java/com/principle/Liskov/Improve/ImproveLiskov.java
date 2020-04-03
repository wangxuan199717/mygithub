package com.principle.Liskov.Improve;


//里式替换原则：类的继承应当遵守的原则，最好不要重写父类的方法
public class ImproveLiskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3="+a.minus(11,3));

        B b = new B();
        System.out.println("11+3="+b.add(11,3));
    }
}
//改进，一般会使AB两个类继承更为基本的类

class Caculate{
    public int minus(int a,int b){
        return 0;
    }
    public int add(int a,int b){
        return 0;
    }
}
class A extends Caculate{
    public int minus(int a,int b){
        return a-b;
    }
}
class B extends Caculate{

    //如果B仍然要使用A的方法可以使用组合
    private A a = new A();
    public int add(int a,int b){
        return a+b;
    }
    public int add9(int a,int b){
        return add(a,b)+9;
    }
}
