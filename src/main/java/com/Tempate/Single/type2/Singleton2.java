package com.Tempate.Single.type2;

//饿汉式单例
public class Singleton2 {
    public static void main(String[] args) {
        Sington sington1 = Sington.getInstance();
        Sington sington2 = Sington.getInstance();
        System.out.println(sington1 == sington2);
    }
}

class Sington{
    private static Sington sington;
    static {
        sington = new Sington();
    }
    private Sington(){}
    public static Sington getInstance(){
        return sington;
    }
}