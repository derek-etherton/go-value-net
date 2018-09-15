package com.derk.govaluenet.data;

public class Placement {

    private int x;
    private int y;
    private int color;

    public Placement(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getPosition(){
        return new int[]{x, y};
    }

    public int getColor() {
        return color;
    }
}
