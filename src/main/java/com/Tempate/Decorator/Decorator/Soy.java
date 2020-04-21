package com.Tempate.Decorator.Decorator;

import com.Tempate.Decorator.DecoratorBy.Drink;

public class Soy extends Decorator {

    public Soy(Drink drink) {
        super(drink);
        setCos(9);
        setDes("豆奶");
    }
}
