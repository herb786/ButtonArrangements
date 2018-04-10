package com.hacaller.hac_2dbutton_arrangement.CircleSector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.hacaller.hac_2dbutton_arrangement.BaseShapeView;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Herbert Caller on 29/05/2017.
 */

public class FourthFractionCircle extends BaseShapeView {


    public FourthFractionCircle(Context context) {
        super(context);
    }

    public FourthFractionCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourthFractionCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                        Canvas.ALL_SAVE_FLAG);
        innerRadius = 0.5f*outterRadius;
        drawTopButton(canvas);
        drawRightButton(canvas);
        drawBottomButton(canvas);
        drawLeftButton(canvas);
        booleanDifference(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }


    private void drawLeftButton(Canvas canvas){
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 75.865948,436.13405", pathSrc, 1f);
        pathSrc = drawSvgPath("C -25,337.00001 -25,177.00001 75.865947,75.865953", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_WW], pathSrc);
    }


    private void drawTopButton(Canvas canvas){
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 436.13405,75.865951", pathSrc, 1f);
        pathSrc = drawSvgPath("C 385,27.000014 323.56337,1.2519842 256,1.2519836 188.43662,1.2519839 125,27.000014 75.865948,75.865952", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NN], pathSrc);
    }


    private void drawRightButton(Canvas canvas){
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 436.13404,75.865942", pathSrc, 1f);
        pathSrc = drawSvgPath("C 485,122.00001 510.74802,188.43661 510.74802,255.99999 510.74802,323.56337 485,387.00001 436.13405,436.13405", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_EE], pathSrc);
    }


    private void drawBottomButton(Canvas canvas){
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 436.13405,436.13405", pathSrc, 1f);
        pathSrc = drawSvgPath("C 390,482.00001 323.56338,510.74802 256,510.74802 188.43662,510.74802 125,487.00001 75.865948,436.13405", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
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
        if (isSameColor(defColors[BTN_NN])){
            indexButton = BTN_NN;
            startBlinkingAnimation();
            if (onClickSectorNN != null){
                onClickSectorNN.onClick();
            }
        }
        if (isSameColor(defColors[BTN_SS])){
            indexButton = BTN_SS;
            startBlinkingAnimation();
            if (onClickSectorSS != null){
                onClickSectorSS.onClick();
            }
        }
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
    }

}
