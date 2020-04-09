package com.Tempate.prototype.improve1;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Farmer farmer = new Farmer("wangxian");
        farmer.sheep = new Sheep("xiaoen",2);
        Farmer farmer1 = (Farmer) farmer.deepClone();
        System.out.println(farmer.toString()+farmer.sheep.hashCode());
        System.out.println(farmer1.toString()+farmer1.sheep.hashCode());
    }
}