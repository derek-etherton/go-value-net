package com.derk.govaluenet.frontend.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.derk.govaluenet.Controller.GridHandler;

/**
 * Sampled basic grid from Rahul Parsani on GitHub:
 * https://gist.github.com/rahulparsani/733689margins
 *
 * Heavily built upon previous version, adding GridHandler for compartmentalization,
 * restricting my grid to a square, and adding an outline option
 *
 *
 *  TODO: Margin support in XML
 */

public class SquareGridView extends View {

    private GridHandler gridHandler;

    private static final int DEFAULT_PAINT_COLOR = Color.BLACK;
    private static final int DEFAULT_NUMBER_OF_ROWS = 18;

    private boolean outline = true;
    private boolean showGrid = true;
    private final Paint paint = new Paint();
    private int numRows = DEFAULT_NUMBER_OF_ROWS;
    private int margins = 50;

    public SquareGridView(Context context) {
        super(context);
        init();
    }

    public SquareGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SquareGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        paint.setColor(DEFAULT_PAINT_COLOR);
    }

    public GridHandler getGridHandler() {
        return gridHandler;
    }

    public void setOutline(boolean outline){
        this.outline = outline;
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
        if (numRows > margins) {
            this.numRows = numRows;
        } else {
            throw new RuntimeException("Cannot have a negative number of rows");
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
            int width = getWidth();

            if (gridHandler == null) {
                gridHandler = new GridHandler(DEFAULT_NUMBER_OF_ROWS,
                        width - margins * 2, margins);
            }

            // Vertical lines
            for (int i = 1; i < numRows; i++) {
                canvas.drawLine(gridHandler.getCoordinate(i), margins,
                        gridHandler.getCoordinate(i), width - margins, paint);
            }

            // Horizontal lines
            for (int i = 1; i < numRows; i++) {
                canvas.drawLine(margins, gridHandler.getCoordinate(i), width - margins,
                        gridHandler.getCoordinate(i), paint);
            }

            if (outline){
                drawOutline(canvas, width);
            }
        }
    }

    private void drawOutline(Canvas canvas, int width){
        canvas.drawLine(margins, margins, width - margins,
                margins, paint);
        canvas.drawLine(margins, width - margins, width - margins,
                width - margins, paint);

        canvas.drawLine(margins, margins, margins,
                width - margins, paint);
        canvas.drawLine(width - margins, margins, width - margins,
                width - margins, paint);

    }

    @Override public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = width > height ? height : width;
        setMeasuredDimension(size, size);
    }
}
