package com.Tempate.Single.type3.improve4;

public class Sington3 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        Singleton singleton1 = Singleton.INSTANCE;
        System.out.println(singleton == singleton1);
    }
}

//枚举实现单例
enum Singleton{
    INSTANCE;
}