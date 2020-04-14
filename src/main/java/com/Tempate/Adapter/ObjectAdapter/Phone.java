package com.Tempate.Adapter.ObjectAdapter;

public class Phone {
    Voltage5V charger;
    public Phone(Voltage5V charger){
        this.charger = charger;
    }
    public void Charging(){
        System.out.println("使用"+charger.Output5v()+"V进行充电");
    }
}
