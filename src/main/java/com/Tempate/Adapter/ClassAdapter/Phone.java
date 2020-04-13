package com.Tempate.Adapter.ClassAdapter;

public class Phone {
    VoltageAdapter charger;
    public Phone(VoltageAdapter charger){
        this.charger = charger;
    }
    public void Charging(){
        if(charger.voltage>6){
            System.out.println("电压为"+charger.voltage+"手机爆炸了！");
        }else {
            System.out.println("正在充电！" + "输入电压");
            charger.Output5v();
        }
    }
}
