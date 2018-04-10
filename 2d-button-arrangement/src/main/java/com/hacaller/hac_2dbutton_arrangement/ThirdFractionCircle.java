package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Herbert Caller on 30/05/2017.
 */

public class ThirdFractionCircle extends BaseShapeView {


    public ThirdFractionCircle(Context context) {
        super(context);
    }

    public ThirdFractionCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ThirdFractionCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        innerRadius = 0.5f*outterRadius;
        // Source image (src)
        drawTopLeftButton(canvas);
        drawTopRightButton(canvas);
        drawBottomButton(canvas);
        // Destination image (dst)
        booleanDifference(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 255.99999,-0.01099", pathSrc, 1f);
        pathSrc = drawSvgPath("C 164.53607,-0.01099 79.375,51.62504 34.287954,127.99452 -12.21156,206.75648 -11.444007,304.79546 34.287956,384.00554", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256.00003", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NW], pathSrc);
    }


    private void drawTopRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 256.00001,-0.01099", pathSrc, 1f);
        pathSrc = drawSvgPath("C 347.46394,-0.01099 428.625,51.62504 477.71205,127.99452 527.16643,204.9355 523.44401,304.79546 477.71204,384.00554", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256.00003", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NE], pathSrc);
    }

    private void drawBottomButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 477.53276,384.31557", pathSrc, 1f);
        pathSrc = drawSvgPath("C 433.91667,459.08338 346.60417,512.00004 255.82093,512.01098 164.00322,512.02204 79.375,459.08338 34.287953,384.00553", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256.00003", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SS], pathSrc);
    }

    private void booleanDifference(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        float dx1 = outterRadius - innerRadius;
        paint.setColor(defColors[3]);
        canvas.drawCircle(superRadius, superRadius, innerRadius, paint);
        canvas.drawBitmap(finalBitmap, dx1, dx1, paint);
        paint.setXfermode(null);

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
        if (isSameColor(defColors[BTN_SS])){
            indexButton = BTN_SS;
            startBlinkingAnimation();
            if (onClickSectorSS != null){
                onClickSectorSS.onClick();
            }
        }
    }

}
