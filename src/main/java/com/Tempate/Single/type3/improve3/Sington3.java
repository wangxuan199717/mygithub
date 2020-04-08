package com.Tempate.Single.type3.improve3;

public class Sington3 {
    public static void main(String[] args) {
        Sington sington1 = Sington.getInstance();
        Sington sington2 = Sington.getInstance();
        System.out.println(sington1 == sington2);
    }
}

//静态内部类
class Sington{
    private static class SingtonInstance{
        private static final Sington sington = new Sington();
    }
    private Sington(){}
    public static Sington getInstance(){
       return SingtonInstance.sington;
    }
}