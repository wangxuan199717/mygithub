package com.Tempate.Decorator.Decorator;

import com.Tempate.Decorator.DecoratorBy.Drink;

public class Mike extends Decorator {

    public Mike(Drink drink) {
        super(drink);
        setCos(6);
        setDes("牛奶");
    }
}
