package com.derk.govaluenet.Controller;

public class GridHandler {
    private int numRows;
    private int numCols;
    private int gridWidth;
    private int gridHeight;


    public GridHandler(int numRows, int numCols, int gridWidth, int gridHeight) {
        this.numCols = numCols;
        this.numRows = numRows;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    public int getXCoordinate(int x){
        return gridWidth * x / numCols;
    }

    public int getYCoordinate(int y){
        return gridHeight * y / numRows;
    }
}
