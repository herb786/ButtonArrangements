package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by herbert on 11/06/2017.
 */

public class SixBoxTriangle extends BaseShapeView {
    public SixBoxTriangle(Context context) {
        super(context);
    }

    public SixBoxTriangle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SixBoxTriangle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        drawTopLeftButton(canvas);
        drawTopRightButton(canvas);
        drawTopButton(canvas);
        drawBottomButton(canvas);
        drawBottomLeftButton(canvas);
        drawBottomRightButton(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 176.08888,159.9607 80.195533,351.91352 256.09777,351.95677 256.04444,159.98036 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NW], pathSrc);
    }


    private void drawTopRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 256.09777,351.95677 432,352.00001 336,160.00001 256.04444,159.98036 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NE], pathSrc);
    }

    private void drawTopButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 256,0 176.08888,159.9607 336,160.00001 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NN], pathSrc);
    }

    private void drawBottomButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 170.6671,351.93562 V 511.91604 L 341.33316,511.9579 V 351.97798 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SS], pathSrc);
    }

    private void drawBottomLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 79.9114,351.9134 0,511.87418 170.38185,511.91604 V 351.93562 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SW], pathSrc);
    }

    private void drawBottomRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 341.33419,351.97798 V 511.9579 L 511.99975,511.99975 431.99999,352.00021 Z";
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
        if (isSameColor(defColors[BTN_SS])){
            indexButton = BTN_SS;
            startBlinkingAnimation();
            if (onClickSectorSS != null){
                onClickSectorSS.onClick();
            }
        }
        if (isSameColor(defColors[BTN_NN])){
            indexButton = BTN_NN;
            startBlinkingAnimation();
            if (onClickSectorNN != null){
                onClickSectorNN.onClick();
            }
        }
    }
}
