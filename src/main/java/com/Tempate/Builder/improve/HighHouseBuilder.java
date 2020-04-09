package com.Tempate.Builder.improve;

public class HighHouseBuilder extends Builder {
    @Override
    public void buildBase() {
        house.setBase("建了深深的地基100米");
        System.out.println(house.getBase());
    }

    @Override
    public void buildWalls() {
        house.setWalls("建了高高的墙200米");
        System.out.println(house.getWalls());
    }

    @Override
    public void buildRoof() {
        house.setRoof("建了大大的屋顶300平米");
        System.out.println(house.getRoof());
    }
}
