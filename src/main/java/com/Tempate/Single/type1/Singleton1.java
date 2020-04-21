package com.Tempate.Single.type1;

//恶汉式单例
public class Singleton1 {
    public static void main(String[] args) {
        Sington sington1 = Sington.getInstance();
        Sington sington2 = Sington.getInstance();
        System.out.println(sington1 == sington2);
    }
}

class Sington{
    private final static Sington sington=new Sington();
    private Sington(){}
    public static Sington getInstance(){
        return sington;
    }
}