package com.Tempate.Single.type3;

public class Sington3 {
    public static void main(String[] args) {
        Sington sington1 = Sington.getInstance();
        Sington sington2 = Sington.getInstance();
        System.out.println(sington1 == sington2);
    }
}

class Sington{
    private static Sington sington;
    private Sington(){}
    public static Sington getInstance(){
        if(sington==null){
            sington = new Sington();
        }
        return sington;
    }
}