package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by herbert on 11/06/2017.
 */

public class Square extends BaseShapeView {
    public Square(Context context) {
        super(context);
    }

    public Square(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Square(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        // Source image (src)
        drawTopButton(canvas);
        drawLeftButton(canvas);
        drawRightButton(canvas);
        drawBottomButton(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 256,0 384,128 256,256 128,128 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NN], pathSrc);
    }

    private void drawLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 128,128 256,256 128,384 0,256 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_WW], pathSrc);
    }

    private void drawRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 384,128 512,256 384,384 256,256 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_EE], pathSrc);
    }


    private void drawBottomButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 256,256 384,384 256,512 128,384 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SS], pathSrc);
    }



    @Override
    protected void onTouchColour() {
        super.onTouchColour();
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
        if (isSameColor(defColors[BTN_WW])){
            indexButton = BTN_WW;
            startBlinkingAnimation();
            if (onClickSectorWW != null){
                onClickSectorWW.onClick();
            }
        }
        if (isSameColor(defColors[BTN_EE])){
            indexButton = BTN_EE;
            startBlinkingAnimation();
            if (onClickSectorEE != null){
                onClickSectorEE.onClick();
            }
        }
    }
}
