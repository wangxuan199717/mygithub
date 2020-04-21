package com.Tempate.Bridge.Phone;

import com.Tempate.Bridge.Brand.Brand;

public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand){
        super(brand);
    }
    public void Call(){
        System.out.println("这是滑盖手机");
        super.Call();
    }
    public void Message(){
        System.out.println("这是滑盖手机");
        super.Message();
    }
}
