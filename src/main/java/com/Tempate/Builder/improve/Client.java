package com.Tempate.Builder.improve;

public class Client {
    public static void main(String[] args) {
        Director director = new Director(new HighHouseBuilder());
        House house = director.directBuilder();
        System.out.println(house);

        director.setHouseBuilder(new CommonHouseBuilder());
        house = director.directBuilder();
        System.out.println(house);
    }
}
