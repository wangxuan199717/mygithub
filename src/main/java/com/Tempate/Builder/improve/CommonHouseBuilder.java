package com.Tempate.Builder.improve;

public class CommonHouseBuilder extends Builder{
    @Override
    public void buildBase() {
        house.setBase("建了浅浅的地基10米");
        System.out.println(house.getBase());
    }

    @Override
    public void buildWalls() {
        house.setWalls("建了矮矮的墙20米");
        System.out.println(house.getWalls());
    }

    @Override
    public void buildRoof() {
        house.setRoof("建了小小的屋顶30平米");
        System.out.println(house.getRoof());
    }
}
