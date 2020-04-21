package com.Tempate.Decorator;

import com.Tempate.Decorator.Decorator.Chocolate;
import com.Tempate.Decorator.Decorator.Soy;
import com.Tempate.Decorator.DecoratorBy.Drink;
import com.Tempate.Decorator.DecoratorBy.LongBlack;

public class CoffeeBar {
    public static void main(String[] args) {
        Drink longBlack = new LongBlack();
        System.out.println(longBlack.getDes());

        Drink order = new Soy(longBlack);
        System.out.println(order.getDes());

        order = new Chocolate(order);
        System.out.println(order.getDes());
        System.out.println(order.Cost());
    }
}
