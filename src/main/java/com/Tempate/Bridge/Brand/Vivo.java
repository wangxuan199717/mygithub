package com.Tempate.Bridge.Brand;

public class Vivo implements Brand {
    @Override
    public void Call() {
        System.out.println("Vivo打电话");
    }

    @Override
    public void Message() {
        System.out.println("Vivo发短信");
    }
}
