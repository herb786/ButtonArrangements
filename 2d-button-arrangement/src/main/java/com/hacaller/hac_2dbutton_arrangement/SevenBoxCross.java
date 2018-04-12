package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by herbert on 11/06/2017.
 */

public class SevenBoxCross extends BaseShapeView {
    public SevenBoxCross(Context context) {
        super(context);
    }

    public SevenBoxCross(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SevenBoxCross(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        drawTopLeftButton(canvas);
        drawTopRightButton(canvas);
        drawLeftButton(canvas);
        drawRightButton(canvas);
        drawMiddleButton(canvas);
        drawBottomLeftButton(canvas);
        drawBottomRightButton(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 255.9995,0 V 170.666 H 85.3335 V 0 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NW], pathSrc);
    }


    private void drawTopRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 426.6665,0 V 170.666 H 256.00049 V 0 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NE], pathSrc);
    }

    private void drawLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 170.666,170.667 V 341.333 H 0 V 170.667 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_WW], pathSrc);
    }

    private void drawRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 512,170.667 V 341.333 H 341.334 V 170.667 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_EE], pathSrc);
    }

    private void drawMiddleButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 341.333,170.667 V 341.333 H 170.667 V 170.667 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_OO], pathSrc);
    }

    private void drawBottomLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 255.99951,341.334 V 512 H 85.333505 V 341.334 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SW], pathSrc);
    }

    private void drawBottomRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 426.6665,341.334 V 512 H 256.00049 V 341.334 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SE], pathSrc);
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
        if (isSameColor(defColors[BTN_EE])){
            indexButton = BTN_EE;
            startBlinkingAnimation();
            if (onClickSectorEE != null){
                onClickSectorEE.onClick();
            }
        }
        if (isSameColor(defColors[BTN_WW])){
            indexButton = BTN_WW;
            startBlinkingAnimation();
            if (onClickSectorWW != null){
                onClickSectorWW.onClick();
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
