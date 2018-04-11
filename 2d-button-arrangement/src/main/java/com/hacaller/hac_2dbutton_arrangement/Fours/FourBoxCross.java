package com.hacaller.hac_2dbutton_arrangement.Fours;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.hacaller.hac_2dbutton_arrangement.BaseShapeView;

/**
 * Created by herbert on 11/06/2017.
 */

public class FourBoxCross extends BaseShapeView {
    public FourBoxCross(Context context) {
        super(context);
    }

    public FourBoxCross(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourBoxCross(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        String srcString = "M 170.66699,0 H 341.33299 V 170.666 H 170.66699 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NN], pathSrc);
    }

    private void drawLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 0,170.66701 H 170.666 V 341.33301 H 0 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_WW], pathSrc);
    }

    private void drawRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 341.33398,170.66701 H 511.99998 V 341.33301 H 341.33398 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_EE], pathSrc);
    }


    private void drawBottomButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 170.66699,341.33401 H 341.33299 V 512.00002 H 170.66699 Z";
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
