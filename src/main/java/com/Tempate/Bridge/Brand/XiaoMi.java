package com.Tempate.Bridge.Brand;

public class XiaoMi implements Brand {
    @Override
    public void Call() {
        System.out.println("小米打电话");
    }

    @Override
    public void Message() {
        System.out.println("小米发短信");
    }
}
