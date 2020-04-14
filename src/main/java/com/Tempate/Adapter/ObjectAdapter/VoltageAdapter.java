package com.Tempate.Adapter.ObjectAdapter;

public class VoltageAdapter implements Voltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }
    @Override
    public int Output5v() {
        if(voltage220V != null)
            return voltage220V.getV()/44;
        else
            return voltage220V.getV();
    }
}
