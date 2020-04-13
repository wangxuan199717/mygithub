package com.Tempate.Adapter.ClassAdapter;

public class VoltageAdapter extends Voltage220V implements Voltage5V{
    int voltage=5;
    @Override
    public void Output5v() {
        this.OutPut();
        System.out.println("适配器将电压变为了"+this.voltage);
    }
}
