package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        //drawButtonC(canvas);
        //drawButtonD(canvas);
        //drawButtonE(canvas);
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
        pathSrc = drawSvgPath("M 0,30.500006", pathSrc, 1f);
        pathSrc = drawSvgPath("V 150.49991", pathSrc, 1f);
        pathSrc = drawSvgPath("C 0,150.49991 40.809052,180.71056 102.39995,204.03049", pathSrc, 1f);
        pathSrc = drawSvgPath("V 97.923281", pathSrc, 1f);
        pathSrc = drawSvgPath("C 65.197518,80.702894 30.06653,53.216253 0,30.500006", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_B], pathSrc);
    }

    private void drawButtonC(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 409.59981,98.00803", pathSrc, 1f);
        pathSrc = drawSvgPath("C 379.22194,112.30997 344.21844,122.1566 307.19985,126.92098", pathSrc, 1f);
        pathSrc = drawSvgPath("V 223.82722", pathSrc, 1f);
        pathSrc = drawSvgPath("C 339.6181,221.71894 368.33614,217.77458 384.08043,212.90075 392.92172,210.13474 401.44049,207.15995 409.59981,204.06615", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_C], pathSrc);
    }

    private void drawButtonD(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 511.99975,30.500006", pathSrc, 1f);
        pathSrc = drawSvgPath("C 511.99975,30.500006 473.52016,62.925934 426.64528,89.241122 421.1488,92.326809 415.45933,95.249354 409.59981,98.00803", pathSrc, 1f);
        pathSrc = drawSvgPath("V 204.06615", pathSrc, 1f);
        pathSrc = drawSvgPath("C 471.17158,180.71966 511.99975,150.49991 511.99975,150.49991", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_D], pathSrc);
    }

    private void drawButtonE(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 102.39995,97.923281", pathSrc, 1f);
        pathSrc = drawSvgPath("V 204.03049", pathSrc, 1f);
        pathSrc = drawSvgPath("C 110.60841,207.13844 119.18104,210.12548 128.08055,212.90075 143.7703,217.76456 172.42299,221.71045 204.7999,223.82206", pathSrc, 1f);
        pathSrc = drawSvgPath("V 126.89775", pathSrc, 1f);
        pathSrc = drawSvgPath("C 167.77365,122.11506 132.76941,112.24747 102.39995,97.923281", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_E], pathSrc);
    }

}
