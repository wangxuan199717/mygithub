package com.principle.singlerresponsobility;

public class SingleResponsbility {
    public static void main(String[] args) {
        Vehicle car = new Vehicle();
        Vehicle plane = new Vehicle();
        Vehicle boat = new Vehicle();

        car.run("小汽车");
        plane.run("飞机");
        boat.run("船");
    }
}


/*
* 分析：
* 由于交通工具类掌管了所有交通工具
* 然而run方法却不能应用所有的交通工具
* 违反了单一职责原则
* */
class Vehicle{
    public void run(String veh){
        System.out.println(veh+"正在公路上运行！");
    }
}
