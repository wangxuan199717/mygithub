package com.principle.interfacesegregation;

public class Interfacesegregation {

    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());
    }
}


//接口定义
interface Interface1{
    void inerface1();
    void inerface2();
    void inerface3();
    void inerface4();
    void inerface5();
}

//类B实现了所有接口
class B implements Interface1{

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

    @Override
    public void inerface4() {
        System.out.println("B实现了接口4");
    }

    @Override
    public void inerface5() {
        System.out.println("B实现了接口5");
    }
}
//类D实现了所有接口
class D implements Interface1{

    @Override
    public void inerface1() {
        System.out.println("D实现了接口1");
    }

    @Override
    public void inerface2() {
        System.out.println("D实现了接口2");
    }

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
//类A使用了B但只用了前三个接口
class A{
    public void depend1(Interface1 interface1) {
        interface1.inerface1();
    }
    public void depend2(Interface1 interface1) {
        interface1.inerface2();
    }
    public void depend3(Interface1 interface1) {
        interface1.inerface3();
    }

}
//类C使用了D但只用了后三个接口
class C{
    public void depend3(Interface1 interface1) {
        interface1.inerface3();
    }
    public void depend4(Interface1 interface1) {
        interface1.inerface4();
    }
    public void depend5(Interface1 interface1) {
        interface1.inerface5();
    }

}
