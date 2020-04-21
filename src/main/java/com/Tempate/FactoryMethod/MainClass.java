package com.Tempate.FactoryMethod;


public class MainClass {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new AppleFactory();
        Apple apple = (Apple) fruitFactory.getFruit();
        apple.get();
        fruitFactory = new PearFactory();
        Pear pear= (Pear)fruitFactory.getFruit();
        pear.get();
    }
}
