package com.Tempate.Builder.improve;

public class House {
    private String base;
    private String walls;
    private String roof;

    public String getBase() {
        return base;
    }

    @Override
    public String toString() {
        if(base != null && walls != null && roof != null)
            return "建好房子了 ！";
        return null;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }
}
