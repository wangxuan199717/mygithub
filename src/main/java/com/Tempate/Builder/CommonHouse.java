package com.Tempate.Builder;

public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBase() {
        System.out.println("普通房打地基！");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子建墙！");
    }

    @Override
    public void roof() {
        System.out.println("普通房子屋顶！");
    }
}
