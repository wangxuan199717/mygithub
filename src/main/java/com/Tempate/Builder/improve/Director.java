package com.Tempate.Builder.improve;

public class Director {
    private Builder houseBuilder = null;
    public Director(Builder builder){
        this.houseBuilder = builder;
    }

    public void setHouseBuilder(Builder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House directBuilder(){
        if(houseBuilder!=null){
            houseBuilder.buildBase();
            houseBuilder.buildWalls();
            houseBuilder.buildRoof();
            return houseBuilder.BuildHouse();
        }
        return null;
    }
}
