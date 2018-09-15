package com.derk.govaluenet.Controller;

// Does not support margins, if margins are needed, wrap the GridView in a FrameLayout

public class GridHandler {
    private int numRows;
    private int gridWidth;
    private int offset;

    public GridHandler(int numRows, int gridWidth, int offset) {
        this.numRows = numRows;
        this.gridWidth = gridWidth;
        this.offset = offset;
    }

    public int getCoordinate(int x){
        return gridWidth * x / numRows + offset;
    }

    public int getStoneSize(){
        return gridWidth / numRows;
    }

    /** Returns the gridline to the left (or above) the given point */
    public int getGridline(int x) {
        return gridWidth * x / numRows - gridWidth  / numRows / 2 + offset;
    }

}
