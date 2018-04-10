package com.hacaller.hac_2dbutton_arrangement.CircleSector;

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

import com.hacaller.hac_2dbutton_arrangement.BaseShapeView;

/**
 * Created by AGB on 31/05/2017.
 */

public class SixthFractionCircle extends BaseShapeView {

    public SixthFractionCircle(Context context) {
        super(context);
    }

    public SixthFractionCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SixthFractionCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        innerRadius = 0.5f*outterRadius;
        drawTopLeftButton(canvas);
        drawTopRightButton(canvas);
        drawTopButton(canvas);
        drawBottomButton(canvas);
        drawBottomLeftButton(canvas);
        drawBottomRightButton(canvas);
        booleanDifference(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 7.6589797e-7,256.0198", pathSrc, 1f);
        pathSrc = drawSvgPath("C -0.00707355,164.55618 49,80.000014 127.99164,34.302323", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NW], pathSrc);
    }


    private void drawTopRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 512,256.0198", pathSrc, 1f);
        pathSrc = drawSvgPath("C 512.00707,164.55618 463,80.000014 384.00836,34.302323", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NE], pathSrc);
    }

    private void drawTopButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 127.99038,34.303053", pathSrc, 1f);
        pathSrc = drawSvgPath("C 207,-10.999986 305,-10.999986 384.01123,34.303979", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NN], pathSrc);
    }

    private void drawBottomButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 127.99038,477.69695", pathSrc, 1f);
        pathSrc = drawSvgPath("C 207,523.00001 305,523.00001 384.01123,477.69602", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SS], pathSrc);
    }

    private void drawBottomLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 7.6589797e-7,256.01981", pathSrc, 1f);
        pathSrc = drawSvgPath("C -0.00707462,347.48343 49,432.00001 127.99164,477.73729", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SW], pathSrc);
    }

    private void drawBottomRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 512,256.01981", pathSrc, 1f);
        pathSrc = drawSvgPath("C 512.00708,347.48343 463,432.00001 384.00836,477.73729", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SE], pathSrc);
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
        if (isSameColor(defColors[BTN_SW])){
            indexButton = BTN_SW;
            startBlinkingAnimation();
            if (onClickSectorSW != null){
                onClickSectorSW.onClick();
            }
        }
        if (isSameColor(defColors[BTN_SE])){
            indexButton = BTN_SE;
            startBlinkingAnimation();
            if (onClickSectorSE != null){
                onClickSectorSE.onClick();
            }
        }
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
    }

}
