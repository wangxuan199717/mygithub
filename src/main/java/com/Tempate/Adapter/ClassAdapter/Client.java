package com.Tempate.Adapter.ClassAdapter;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone(new VoltageAdapter());
        phone.Charging();
    }
}
