package com.hacaller.hac_2dbutton_arrangement.Fives;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.hacaller.hac_2dbutton_arrangement.BaseShapeView;

/**
 * Created by herbert on 11/06/2017.
 */

public class FiveSegmentCircle extends BaseShapeView {
    public FiveSegmentCircle(Context context) {
        super(context);
    }

    public FiveSegmentCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FiveSegmentCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        drawMiddleButton(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 74.980661,74.980667 C 161.46328,-10.812965 310.39031,-25.021001 408.15163,49.797703 418.41235,57.420897 428.07008,65.853843 437.01933,74.980656 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NN], pathSrc);
    }

    private void drawLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 74.980662,437.01933 C -12.493338,351.47972 -23.688497,202.31592 49.832306,104.58357 57.447984,94.096943 65.867264,84.195159 74.980661,74.980667 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_EE], pathSrc);
    }

    private void drawRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 437.01933,74.980656 C 535.50026,170.72887 535.60188,341.19405 437.01934,437.01934 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_WW], pathSrc);
    }


    private void drawBottomButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 437.01934,437.01934 C 341.35327,535.34298 170.73383,535.36957 74.980662,437.01933 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SS], pathSrc);
    }

    private void drawMiddleButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 437.99998,256 256,437.99998 74.000019,256 256,74.000019 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_OO], pathSrc);
    }



    @Override
    protected void onTouchColour() {
        super.onTouchColour();
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
        if (isSameColor(defColors[BTN_SS])){
            indexButton = BTN_SS;
            startBlinkingAnimation();
            if (onClickSectorSS != null){
                onClickSectorSS.onClick();
            }
        }
        if (isSameColor(defColors[BTN_OO])){
            indexButton = BTN_OO;
            startBlinkingAnimation();
            if (onClickSectorOO != null){
                onClickSectorOO.onClick();
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
