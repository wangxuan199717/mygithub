package com.principle.interfacesegregation.improve;

public class ImproveInterface {

    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());
    }
}


//接口1定义
interface Interface1{
    void inerface1();
    void inerface2();
}
//接口2定义
interface Interface2{
    void inerface3();
}
//接口3定义
interface Interface3{
    void inerface4();
    void inerface5();
}

//类B实现了所有接口1和接口2即满足了A的需求
class B implements Interface1 , Interface2{

    @Override
    public void inerface1() {
        System.out.println("B实现了接口1");
    }

    @Override
    public void inerface2() {
        System.out.println("B实现了接口2");
    }

    @Override
    public void inerface3() {
        System.out.println("B实现了接口3");
    }
}
//类D实现了接口2和接口3 满足了C的需求
class D implements Interface2 , Interface3{

    @Override
    public void inerface3() {
        System.out.println("D实现了接口3");
    }

    @Override
    public void inerface4() {
        System.out.println("D实现了接口4");
    }

    @Override
    public void inerface5() {
        System.out.println("D实现了接口5");
    }
}
//类A使用了B
class A{
    public void depend1(Interface1 interface1) {
        interface1.inerface1();
    }
    public void depend2(Interface1 interface1) {
        interface1.inerface2();
    }
    public void depend3(Interface2 interface1) {
        interface1.inerface3();
    }

}
//类C使用了D
class C{
    public void depend3(Interface2 interface1) {
        interface1.inerface3();
    }
    public void depend4(Interface3 interface1) {
        interface1.inerface4();
    }
    public void depend5(Interface3 interface1) {
        interface1.inerface5();
    }

}
