package com.principle.singlerresponsobility.improve;

public class ImproveSingle {
    public static void main(String[] args) {

        //改进1
        Car car = new Car();
        Boat boat = new Boat();
        Plane plane = new Plane();

        car.run();
        boat.run();
        plane.run();

        //改进2
        Vehcile vehcile = new Vehcile();
        vehcile.runAir();
        vehcile.runPlane();
        vehcile.runRoad();
    }
}

//改进1
//遵守了单一职责原则，但改动太大
class Car{
    public void run(){
        System.out.println("小汽车正在公路上运行！");
    }
}
class Boat{
    public void run(){
        System.out.println("船正在海上运行！");
    }
}
class Plane{
    public void run(){
        System.out.println("飞机正在天上运行！");
    }
}
//改进2
class Vehcile{
    public void runRoad(){
        System.out.println("小汽车正在天上运行！");
    }
    public void runAir(){
        System.out.println("飞机正在天上运行！");
    }
    public void runPlane(){
        System.out.println("船正在天上运行！");
    }

}
