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

public class FiveBoxSnake extends BaseRectShapeView {
    public FiveBoxSnake(Context context) {
        super(context);
    }

    public FiveBoxSnake(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FiveBoxSnake(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        String srcString = "M 102.39995,33.295535 C 73.304963,36.118951 39.950691,45.704678 0,65.516824 V 184.53643 C 39.950691,164.72429 73.304963,155.13856 102.39995,152.31514 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_A], pathSrc);
    }

    private void drawButtonB(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 121.03137,32.374661 C 115.01155,32.377111 108.80825,32.673664 102.39995,33.295535 V 152.31514 C 142.62048,148.41209 174.69876,157.43674 204.7999,170.25306 V 51.233457 C 179.49474,40.459145 152.79392,32.361731 121.03137,32.374661 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_B], pathSrc);
    }

    private void drawButtonC(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 204.7999,51.233457 V 170.25306 C 238.52303,184.61154 269.76932,203.72239 307.19985,214.75061 V 95.730999 C 269.76932,84.702788 238.52303,65.591934 204.7999,51.233457 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_C], pathSrc);
    }

    private void drawButtonD(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 307.19985,95.730999 V 214.75061 C 336.25348,223.31072 369.03451,226.99911 409.59981,219.80404 V 100.78444 C 369.03451,107.9795 336.25348,104.29111 307.19985,95.730999 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_D], pathSrc);
    }

    private void drawButtonE(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 511.99975,65.516824 C 472.71061,84.567911 439.09839,95.552273 409.59981,100.78444 V 219.80404 C 439.09839,214.57188 472.71061,203.58752 511.99975,184.53643 Z";
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
