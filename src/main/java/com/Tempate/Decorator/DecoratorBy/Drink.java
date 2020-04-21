package com.Tempate.Decorator.DecoratorBy;

public abstract class Drink {
    private String des;
    private int cos;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCos() {
        return cos;
    }

    public void setCos(int cos) {
        this.cos = cos;
    }

    public abstract int Cost();
}
