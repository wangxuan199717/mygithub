package com.Tempate.Decorator.Decorator;

import com.Tempate.Decorator.DecoratorBy.Drink;

public class Decorator extends Drink {
    private Drink drink;
    public Decorator(Drink drink){
        this.drink=drink;
    }
    @Override
    public int Cost() {
        return super.getCos()+drink.Cost();
    }
    public String getDes(){
        return super.getDes()+" "+ super.getCos() +"&&"+drink.getDes();
    }
}
