package com.Tempate.Bridge.Phone;

import com.Tempate.Bridge.Brand.Brand;

public class UpRightPhone extends Phone {
    public UpRightPhone(Brand brand) {
        super(brand);
    }
    public void Call(){
        System.out.println("这是翻盖手机");
        super.Call();
    }
    public void Message(){
        System.out.println("这是翻盖手机");
        super.Message();
    }
}
