package com.Tempate.Bridge.Phone;

import com.Tempate.Bridge.Brand.Brand;

public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand){
        super();
        this.brand=brand;
    }

    public void Call(){
        if(brand!=null){
            brand.Call();
        }
    }
    public void Message(){
        if(brand!=null){
            brand.Message();
        }
    }
}
