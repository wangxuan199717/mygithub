package com.Tempate.Bridge.Phone;

import com.Tempate.Bridge.Brand.Brand;

public class UpRightPhone extends Phone {
    public UpRightPhone(Brand brand) {
        super(brand);
    }
    public void UpRightCall(){
        System.out.println("这是翻盖手机");
        super.Call();
    }
    public void UpRightMessage(){
        System.out.println("这是翻盖手机");
        super.Message();
    }
}
