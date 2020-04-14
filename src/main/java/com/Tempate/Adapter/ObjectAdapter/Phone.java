package com.Tempate.Adapter.ObjectAdapter;

public class Phone {
    Voltage5V charger;
    public Phone(Voltage5V charger){
        this.charger = charger;
    }
    public void Charging(){
        if(charger.Output5v()>6){
            System.out.println("手机爆炸"+charger.Output5v());
        }else {
            System.out.println("使用" + charger.Output5v() + "V进行充电");
        }
    }
}
