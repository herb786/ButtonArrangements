package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by herbert on 11/06/2017.
 */

public class FiveBoxChecker extends BaseShapeView {

    private float unitLength;

    public FiveBoxChecker(Context context) {
        super(context);
    }

    public FiveBoxChecker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FiveBoxChecker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        unitLength = 2*superRadius/3f;
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        drawTopLeftButton(canvas);
        drawTopRightButton(canvas);
        drawMiddleButton(canvas);
        drawBottomLeftButton(canvas);
        drawBottomRightButton(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas) {
        clearCoords();
        String rect = "<rect\n" +
                "     y=\"0.0010070801\"\n" +
                "     x=\"-0.66599464\"\n" +
                "     height=\"170.666\"\n" +
                "     width=\"170.666\"\n" +
                "     id=\"rect4698\"\n" +
                "     style=\"opacity:0.15;fill:#d45500;fill-opacity:1;stroke:none;stroke-width:0.26458332\" />";
        drawColorRectBitmap(canvas, rect, defColors[BTN_NW]);
    }

    private void drawTopRightButton(Canvas canvas) {
        clearCoords();
        String rect = "<rect\n" +
                "     y=\"0.0010070801\"\n" +
                "     x=\"341.33301\"\n" +
                "     height=\"170.666\"\n" +
                "     width=\"170.666\"\n" +
                "     id=\"rect4702\"\n" +
                "     style=\"opacity:0.15;fill:#806600;fill-opacity:1;stroke:none;stroke-width:0.26458332\" />";
        drawColorRectBitmap(canvas, rect, defColors[BTN_NE]);
    }

    private void drawMiddleButton(Canvas canvas) {
        clearCoords();
        String rect = "<rect\n" +
                "     style=\"opacity:0.15;fill:#0000ff;fill-opacity:1;stroke:none;stroke-width:0.26458332\"\n" +
                "     id=\"rect4696\"\n" +
                "     width=\"170.666\"\n" +
                "     height=\"170.666\"\n" +
                "     x=\"170.66699\"\n" +
                "     y=\"170.66701\" />";
        drawColorRectBitmap(canvas, rect, defColors[BTN_OO]);
    }

    private void drawBottomLeftButton(Canvas canvas) {
        clearCoords();
        String rect = "<rect\n" +
                "     y=\"341.33301\"\n" +
                "     x=\"0.00099182129\"\n" +
                "     height=\"170.666\"\n" +
                "     width=\"170.666\"\n" +
                "     id=\"rect4704\"\n" +
                "     style=\"opacity:0.15;fill:#ff00ff;fill-opacity:1;stroke:none;stroke-width:0.26458332\" />";
        drawColorRectBitmap(canvas, rect, defColors[BTN_SW]);
    }

    private void drawBottomRightButton(Canvas canvas) {
        clearCoords();
        String rect = "<rect\n" +
                "     style=\"opacity:0.15;fill:#008000;fill-opacity:1;stroke:none;stroke-width:0.26458332\"\n" +
                "     id=\"rect4706\"\n" +
                "     width=\"170.666\"\n" +
                "     height=\"170.666\"\n" +
                "     x=\"341.33301\"\n" +
                "     y=\"341.33301\" />";
        drawColorRectBitmap(canvas, rect, defColors[BTN_SE]);
    }

    @Override
    protected void onTouchColour() {
        super.onTouchColour();
        if (isSameColor(defColors[BTN_NE])){
            indexButton = BTN_NE;
            startBlinkingAnimation();
            if (onClickSectorNE != null){
                onClickSectorNE.onClick();
            }
        }
        if (isSameColor(defColors[BTN_NW])){
            indexButton = BTN_NW;
            startBlinkingAnimation();
            if (onClickSectorNW != null){
                onClickSectorNW.onClick();
            }
        }
        if (isSameColor(defColors[BTN_SW])){
            indexButton = BTN_SW;
            startBlinkingAnimation();
            if (onClickSectorSW != null){
                onClickSectorSW.onClick();
            }
        }
        if (isSameColor(defColors[BTN_SE])){
            indexButton = BTN_SE;
            startBlinkingAnimation();
            if (onClickSectorSE != null){
                onClickSectorSE.onClick();
            }
        }
        if (isSameColor(defColors[BTN_OO])){
            indexButton = BTN_OO;
            startBlinkingAnimation();
            if (onClickSectorOO != null){
                onClickSectorOO.onClick();
            }
        }
    }
}
