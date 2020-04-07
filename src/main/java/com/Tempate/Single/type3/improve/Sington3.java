package com.Tempate.Single.type3.improve;

public class Sington3 {
    public static void main(String[] args) {
        Sington sington1 = Sington.getInstance();
        Sington sington2 = Sington.getInstance();
        System.out.println(sington1 == sington2);
    }
}

//增加线程同步,但是效率低下
class Sington{
    private static Sington sington;
    private Sington(){}
    public static synchronized Sington getInstance(){
        if(sington==null){
            sington = new Sington();
        }
        return sington;
    }
}