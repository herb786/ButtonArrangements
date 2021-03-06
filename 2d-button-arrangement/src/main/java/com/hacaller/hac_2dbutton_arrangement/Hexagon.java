package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by herbert on 11/06/2017.
 */

public class Hexagon extends BaseShapeView {

    public Hexagon(Context context) {
        super(context);
    }

    public Hexagon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Hexagon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        String srcString = "M 127.99994,34.297649 0,255.99987 255.99987,256.00013 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NW], pathSrc);
    }


    private void drawTopRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 384.00007,34.297649 512,255.99987 256.00013,256.00013 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NE], pathSrc);
    }

    private void drawTopButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 127.99994,34.297649 255.99987,255.99987 383.99981,34.297649 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NN], pathSrc);
    }

    private void drawBottomButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 255.99987,255.99987 127.99994,477.70261 H 383.99981 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SS], pathSrc);
    }

    private void drawBottomLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 0,255.99987 127.99994,477.70261 255.99987,256.00013 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SW], pathSrc);
    }

    private void drawBottomRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 512,255.99987 384.00007,477.70261 256.00013,256.00013 Z";
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
