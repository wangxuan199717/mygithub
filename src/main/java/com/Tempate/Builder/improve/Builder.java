package com.Tempate.Builder.improve;

public abstract class Builder {
    House house = new House();
    public abstract void buildBase();
    public abstract void buildWalls();
    public abstract void buildRoof();

    public House BuildHouse(){
        return house;
    }
}
