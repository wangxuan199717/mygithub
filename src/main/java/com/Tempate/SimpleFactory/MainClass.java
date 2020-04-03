package com.Tempate.SimpleFactory;

public class MainClass {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
       /* Apple apple = new Apple();
        Banana banana = new Banana();
        apple.get();
        banana.get();*/
       /*Fruit apple = new Apple();
       Fruit banana = new Banana();
       apple.get();
       banana.get();*/

       Fruit apple = FruitFactory.getFruit1("Apple");
       Fruit banana = FruitFactory.getFruit("banana");
       apple.get();
       banana.get();
    }
}


class Apple implements Fruit{
    public void get(){
        System.out.println("采集苹果!");
    }
}
class Banana implements Fruit{
    public void get(){
        System.out.println("采集香蕉!");
    }
}
class FruitFactory{
    /*
    *
    * */
    public static Fruit getApple(){
        return  new Apple();
    }
    public static Fruit getBanana(){
        return  new Banana();
    }
    public static Fruit getFruit(String type) throws IllegalAccessException, InstantiationException {
        if(type.equalsIgnoreCase("apple")){
            return Apple.class.newInstance();
        }
        if(type.equalsIgnoreCase("banana")){
            return Banana.class.newInstance();
        }
        return null;
    }
    public static Fruit getFruit1(String type) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class fruit = Class.forName(type);
        return (Fruit) fruit.newInstance();
    }
}