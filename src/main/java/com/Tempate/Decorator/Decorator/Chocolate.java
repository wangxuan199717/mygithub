package com.Tempate.Decorator.Decorator;

import com.Tempate.Decorator.DecoratorBy.Drink;

public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        setCos(5);
        setDes("巧克力");
    }
}
