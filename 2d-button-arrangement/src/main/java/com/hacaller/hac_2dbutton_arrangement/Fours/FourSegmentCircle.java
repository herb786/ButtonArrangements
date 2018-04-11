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

public class FourSegmentCircle extends BaseShapeView {
    public FourSegmentCircle(Context context) {
        super(context);
    }

    public FourSegmentCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourSegmentCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        // Source image (src)
        drawRightButton(canvas);
        drawBottomButton(canvas);
        drawLeftButton(canvas);
        drawTopButton(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 35.52383,125.89905 C 112.1576,-15.301462 325.53316,-43.099077 435.7851,73.754791 L 438.7313,76.708976 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NN], pathSrc);
    }

    private void drawLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 128.29937,477.87508 C -13.72447,402.77816 -43.836056,189.71684 71.814448,78.203255 L 74.736486,75.225172 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_WW], pathSrc);
    }

    private void drawRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 382.22285,33.28091 C 524.74277,107.43204 556.27006,320.28848 441.36342,432.56841 L 438.46125,435.56585 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_EE], pathSrc);
    }


    private void drawBottomButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 479.07517,381.59246 C 444.10613,450.27255 372.81219,495.76735 297.6687,507.65645 221.5406,520.62661 138.10033,499.70534 82.613925,444.52086 80.751199,442.64411 78.866553,440.79112 76.950892,438.96835 Z";
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
