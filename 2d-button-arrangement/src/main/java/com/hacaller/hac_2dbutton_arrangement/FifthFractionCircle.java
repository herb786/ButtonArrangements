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

/**
 * Created by herbert on 31/05/2017.
 */

public class FifthFractionCircle extends BaseShapeView {

    public FifthFractionCircle(Context context) {
        super(context);
    }

    public FifthFractionCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FifthFractionCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setFilterBitmap(false);
        canvas.drawRect(0, 0, getWidth(), getWidth(), paint);
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        innerRadius = 0.5f*outterRadius;
        // Source image (src)
        drawTopLeftButton(canvas);
        drawTopRightButton(canvas);
        drawBottomLeftButton(canvas);
        drawBottomRightButton(canvas);
        drawBottom(canvas);
        // Destination image (dst)
        booleanDifference(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 255.981,0.0579841", pathSrc, 1f);
        pathSrc = drawSvgPath("C 145.18359,0.06620753 46,71.000014 12.614805,176.68767", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NW], pathSrc);
    }

    private void drawTopRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 256.019,0.0579841", pathSrc, 1f);
        pathSrc = drawSvgPath("C 366.81641,0.06620536 465,72.000014 499.3852,176.68767", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NE], pathSrc);
    }


    private void drawBottomRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 12.782051,176.17664", pathSrc, 1f);
        pathSrc = drawSvgPath("C -21.941053,281.89947 15,398.00001 105.68783,463.28311", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SE], pathSrc);
    }

    private void drawBottom(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 105.61157,463.22777", pathSrc, 1f);
        pathSrc = drawSvgPath("C 195,528.00001 317,528.00001 406.53545,463.12097", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SS], pathSrc);
    }

    private void drawBottomLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 499.21795,176.17664", pathSrc, 1f);
        pathSrc = drawSvgPath("C 533.94105,281.89947 496,398.00001 406.31217,463.28311", pathSrc, 1f);
        pathSrc = drawSvgPath("L 256,256", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SW], pathSrc);
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
    }

}
