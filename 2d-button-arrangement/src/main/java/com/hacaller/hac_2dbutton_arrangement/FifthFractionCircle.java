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
        drawTopLeftButton(canvas, paint);
        drawTopRightButton(canvas, paint);
        drawBottomLeftButton(canvas, paint);
        drawBottomRightButton(canvas, paint);
        drawBottom(canvas, paint);
        // Destination image (dst)
        booleanDiffence(canvas, paint);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, 0f);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, -90f, -72f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_NW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawTopRightButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, 0f);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, -90f, 72f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_NE], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }


    private void drawBottomRightButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(0f, 0f);
        pathSrc.lineTo(outterRadius, 0f);
        Matrix rmatrix = new Matrix();
        rmatrix.setRotate(-18f);
        pathSrc.transform(rmatrix);
        Matrix tmatrix = new Matrix();
        tmatrix.setTranslate(outterRadius,outterRadius);
        pathSrc.transform(tmatrix);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, -18f, 72f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_SE], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawBottom(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(0f, 0f);
        pathSrc.lineTo(outterRadius, 0f);
        Matrix rmatrix = new Matrix();
        rmatrix.setRotate(54f);
        pathSrc.transform(rmatrix);
        Matrix tmatrix = new Matrix();
        tmatrix.setTranslate(outterRadius,outterRadius);
        pathSrc.transform(tmatrix);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, 54f, 72f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_SS], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawBottomLeftButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(0f, 0f);
        pathSrc.lineTo(outterRadius, 0f);
        Matrix rmatrix = new Matrix();
        rmatrix.setRotate(126f);
        pathSrc.transform(rmatrix);
        Matrix tmatrix = new Matrix();
        tmatrix.setTranslate(outterRadius,outterRadius);
        pathSrc.transform(tmatrix);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, 126f, 72f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_SW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }


    private void booleanDiffence(Canvas canvas, Paint paint) {
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        float dx1 = outterRadius - innerRadius;
        Bitmap bmDst = makeCircleDst(defColors[3], (int) (2*innerRadius));
        canvas.drawBitmap(bmDst, dx1, dx1, paint);
        paint.setXfermode(null);

    }

    @Override
    protected void onTouchInsideSlice() {
        super.onTouchInsideSlice();
        if (touchX > 0 && touchY > Math.tan(18f*Math.PI/180f)*touchX){
            indexButton = BTN_NE;
            startBlinkingAnimation();
            if (onClickTopRightSlice != null){
                onClickTopRightSlice.onClick();
            }
        }
        if (touchX < 0 && touchY > -Math.tan(18f*Math.PI/180f)*touchX){
            indexButton = BTN_NW;
            startBlinkingAnimation();
            if (onClickTopLeftSlice != null){
                onClickTopLeftSlice.onClick();
            }
        }

        if (touchX < 0 && touchY < -Math.tan(18f*Math.PI/180f)*touchX
                && touchY > Math.tan(54f*Math.PI/180f)*touchX ){
            indexButton = BTN_SW;
            startBlinkingAnimation();
            if (onClickBottomLeftSlice != null) {
                onClickBottomLeftSlice.onClick();
            }
        }

        if (touchX > 0 && touchY < Math.tan(18f*Math.PI/180f)*touchX
                && touchY > -Math.tan(54f*Math.PI/180f)*touchX ){
            indexButton = BTN_SE;
            startBlinkingAnimation();
            if (onClickBottomRightSlice != null) {
                onClickBottomRightSlice.onClick();
            }
        }

        if (touchY < 0 && touchX < -Math.tan(36f*Math.PI/180f)*touchY
                && touchX > Math.tan(36f*Math.PI/180f)*touchY) {
            indexButton = BTN_SS;
            startBlinkingAnimation();
            if (onClickBottomRightSlice != null) {
                onClickBottomRightSlice.onClick();
            }
        }

    }

}
