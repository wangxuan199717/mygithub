package com.Tempate.prototype.improve;

public class MainClass {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom",2);
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();



    }
}
