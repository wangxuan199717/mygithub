package com.Tempate.Adapter.ObjectAdapter;

public class VoltageAdapter implements Voltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }
    @Override
    public int Output5v() {
            return voltage220V.getV()/44;
    }
}
