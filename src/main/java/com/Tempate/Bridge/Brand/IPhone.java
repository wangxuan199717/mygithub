package com.Tempate.Bridge.Brand;

public class IPhone implements Brand {
    @Override
    public void Call() {
        System.out.println("苹果打电话");
    }

    @Override
    public void Message() {
        System.out.println("苹果发短信");
    }
}
