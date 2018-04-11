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

public class FiveBoxStairs extends BaseRectShapeView {
    public FiveBoxStairs(Context context) {
        super(context);
    }

    public FiveBoxStairs(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FiveBoxStairs(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        String srcString = "";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_A], pathSrc);
    }

    private void drawButtonB(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_B], pathSrc);
    }

    private void drawButtonC(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_C], pathSrc);
    }

    private void drawButtonD(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_D], pathSrc);
    }

    private void drawButtonE(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "";
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
