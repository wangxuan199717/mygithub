package com.Tempate.Bridge.Phone;

import com.Tempate.Bridge.Brand.Brand;

public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand){
        super(brand);
    }
    public void FoldCall(){
        System.out.println("这是滑盖手机");
        super.Call();
    }
    public void FoldMessage(){
        System.out.println("这是滑盖手机");
        super.Message();
    }
}
