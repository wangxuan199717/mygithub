package com.Tempate.Builder;

public abstract class AbstractHouse {
    public abstract void buildBase();
    public abstract void buildWalls();
    public abstract void roof();

    public void Build(){
        buildBase();
        buildWalls();
        roof();
    }
}
