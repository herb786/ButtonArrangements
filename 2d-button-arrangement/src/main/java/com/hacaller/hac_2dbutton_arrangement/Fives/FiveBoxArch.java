package com.hacaller.hac_2dbutton_arrangement.Fives;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.hacaller.hac_2dbutton_arrangement.BaseRectShapeView;

/**
 * Created by herbert on 11/06/2017.
 */

public class FiveBoxArch extends BaseRectShapeView {

    public FiveBoxArch(Context context) {
        super(context);
    }

    public FiveBoxArch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FiveBoxArch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        drawButtonA(canvas);
        drawButtonB(canvas);
        drawButtonC(canvas);
        drawButtonD(canvas);
        drawButtonE(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawButtonA(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 0,30.500006 V 150.49991 C 0,150.49991 40.809052,180.71056 102.39995,204.03049 V 97.923281 C 65.197518,80.702894 30.06653,53.216253 0,30.500006 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_A], pathSrc);
    }

    private void drawButtonB(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 102.39995,97.923281 V 204.03049 C 136.23128,217.58888 174.81182,221.79284 204.7999,223.82206 V 126.89775 C 167.77365,122.11506 132.76941,112.24747 102.39995,97.923281 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_B], pathSrc);
    }

    private void drawButtonC(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 204.7999,126.89775 V 223.82206 C 239.92153,226.01106 274.24232,225.92964 307.19985,223.82722 V 126.92098 C 272.09337,131.19766 237.53139,131.04429 204.7999,126.89775 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_C], pathSrc);
    }

    private void drawButtonD(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 409.59981,98.00803 C 379.22194,112.30997 344.21844,122.1566 307.19985,126.92098 V 223.82722 C 342.99013,222.19354 376.33829,216.13736 409.59981,204.06615 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_D], pathSrc);
    }

    private void drawButtonE(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 511.99975,30.500006 C 473.28473,58.159656 448.20465,79.771288 409.59981,98.00803 V 204.06615 C 471.17158,180.71966 511.99975,150.49991 511.99975,150.49991 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_E], pathSrc);
    }

    @Override
    protected void onTouchColour() {
        super.onTouchColour();
        if (isSameColor(defColors[BTN_A])){
            indexButton = BTN_A;
            startBlinkingAnimation();
            if (onClickButtonA != null){
                onClickButtonA.onClick();
            }
        }
        if (isSameColor(defColors[BTN_B])){
            indexButton = BTN_B;
            startBlinkingAnimation();
            if (onClickButtonB != null){
                onClickButtonB.onClick();
            }
        }
        if (isSameColor(defColors[BTN_C])){
            indexButton = BTN_C;
            startBlinkingAnimation();
            if (onClickButtonC != null){
                onClickButtonC.onClick();
            }
        }
        if (isSameColor(defColors[BTN_D])){
            indexButton = BTN_D;
            startBlinkingAnimation();
            if (onClickButtonD != null){
                onClickButtonD.onClick();
            }
        }
        if (isSameColor(defColors[BTN_E])){
            indexButton = BTN_E;
            startBlinkingAnimation();
            if (onClickButtonE != null){
                onClickButtonE.onClick();
            }
        }
    }

}
