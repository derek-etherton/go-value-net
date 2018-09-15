package com.derk.govaluenet.frontend.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.derk.govaluenet.Controller.GridHandler;

/**
 * Modified from Rahul Parsani on GitHub:
 * https://gist.github.com/rahulparsani/7336890
 *
 * I changed the default grid size & colour, and implemented a GridHandler for compartmentalization
 */

public class GridView extends View {

    private GridHandler gridHandler;

    private static final int DEFAULT_PAINT_COLOR = Color.BLACK;
    private static final int DEFAULT_NUMBER_OF_ROWS = 19;
    private static final int DEFAULT_NUMBER_OF_COLUMNS = 19;

    private boolean showGrid = true;
    private final Paint paint = new Paint();
    private int numRows = DEFAULT_NUMBER_OF_ROWS, numColumns = DEFAULT_NUMBER_OF_COLUMNS;

    public GridView(Context context) {
        super(context);
        init();
    }

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /*
    public GridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }*/

    private void init() {
        paint.setColor(DEFAULT_PAINT_COLOR);
        //gridHandler = new GridHandler(DEFAULT_NUMBER_OF_ROWS, DEFAULT_NUMBER_OF_COLUMNS,
         //       getWidth(), getHeight());
    }

    public GridHandler getGridHandler() {
        return gridHandler;
    }

    public void setLineColor(int color) {
        paint.setColor(color);
    }

    public void setStrokeWidth(int pixels) {
        paint.setStrokeWidth(pixels);
    }

    public int getNumberOfRows() {
        return numRows;
    }

    public void setNumberOfRows(int numRows) {
        if (numRows > 0) {
            this.numRows = numRows;
        } else {
            throw new RuntimeException("Cannot have a negative number of rows");
        }
    }

    public int getNumberOfColumns() {
        return numColumns;
    }

    public void setNumberOfColumns(int numColumns) {
        if (numColumns > 0) {
            this.numColumns = numColumns;
        } else {
            throw new RuntimeException("Cannot have a negative number of columns");
        }
    }

    public boolean isGridShown() {
        return showGrid;
    }

    public void toggleGrid() {
        showGrid = !showGrid;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (showGrid) {
            if (gridHandler == null) {
                gridHandler = new GridHandler(DEFAULT_NUMBER_OF_ROWS, DEFAULT_NUMBER_OF_COLUMNS,
                        getMeasuredWidth(), getMeasuredHeight());
            }

            int width = getWidth();
            int height = getHeight();

            // Vertical lines
            for (int i = 1; i < numColumns; i++) {
                canvas.drawLine(gridHandler.getXCoordinate(i), 0,
                        gridHandler.getXCoordinate(i), height, paint);
            }

            // Horizontal lines
            for (int i = 1; i < numRows; i++) {
                canvas.drawLine(0, gridHandler.getYCoordinate(i), width,
                        gridHandler.getYCoordinate(i), paint);
            }
        }
    }
}
