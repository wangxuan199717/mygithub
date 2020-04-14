package com.Tempate.Adapter.InterfaceAdapter;

public class Clinet {
    public static void main(String[] args) {
        InterfaceAdapter interfaceAdapter = new InterfaceAdapter(){
            public void int1(){
                System.out.println("实现了接口1");
            }
        };
        interfaceAdapter.int1();
    }
}
