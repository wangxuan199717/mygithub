package com.Tempate.Adapter.ObjectAdapter;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone(new VoltageAdapter(new Voltage220V()));
        phone.Charging();
    }
}
