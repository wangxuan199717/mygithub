package com.Tempate.Adapter.ObjectAdapter;

public class Voltage220V {
    int v=220;

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void OutPut(){
        System.out.println("高压电正在输出"+v+"V的电压！");
    }
}
