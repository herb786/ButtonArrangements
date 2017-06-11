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
        canvas.drawColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setFilterBitmap(false);
        canvas.drawRect(0, 0, getWidth(), getWidth(), paint);
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);
        innerRadius = 0.5f*outterRadius;
        drawTopLeftButton(canvas, paint);
        drawTopRightButton(canvas, paint);
        drawLeftButton(canvas, paint);
        drawRightButton(canvas, paint);
        drawBottomLeftButton(canvas, paint);
        drawBottomRightButton(canvas, paint);
        booleanDiffence(canvas, paint);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, 0f);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, -90f, -60f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_NW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }


    private void drawTopRightButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, 0f);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, -90f, 60f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_NE], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawLeftButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(0f, 0f);
        pathSrc.lineTo(outterRadius, 0f);
        Matrix rmatrix = new Matrix();
        rmatrix.setRotate(-30f);
        pathSrc.transform(rmatrix);
        Matrix tmatrix = new Matrix();
        tmatrix.setTranslate(outterRadius,outterRadius);
        pathSrc.transform(tmatrix);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, -30f, 60f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_WW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawRightButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(0f, 0f);
        pathSrc.lineTo(outterRadius, 0f);
        Matrix rmatrix = new Matrix();
        rmatrix.setRotate(150f);
        pathSrc.transform(rmatrix);
        Matrix tmatrix = new Matrix();
        tmatrix.setTranslate(outterRadius,outterRadius);
        pathSrc.transform(tmatrix);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, 150f, 60f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_EE], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawBottomLeftButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, 0f);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, 90f, 60f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_SW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawBottomRightButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, 0f);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, 90f, -60f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_SE], 2*superRadius);
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
        if (touchX > 0 && touchY > Math.tan(30f*Math.PI/180f)*touchX){
            indexButton = BTN_NE;
            startBlinkingAnimation();
            if (onClickTopRightSlice != null){
                onClickTopRightSlice.onClick();
            }
        }
        if (touchX < 0 && touchY > -Math.tan(30f*Math.PI/180f)*touchX){
            indexButton = BTN_NW;
            startBlinkingAnimation();
            if (onClickTopLeftSlice != null){
                onClickTopLeftSlice.onClick();
            }
        }

        if (touchX > 0 && touchY < -Math.tan(30f*Math.PI/180f)*touchX){
            indexButton = BTN_SE;
            startBlinkingAnimation();
            if (onClickTopRightSlice != null){
                onClickTopRightSlice.onClick();
            }
        }
        if (touchX < 0 && touchY < Math.tan(30f*Math.PI/180f)*touchX){
            indexButton = BTN_SW;
            startBlinkingAnimation();
            if (onClickTopLeftSlice != null){
                onClickTopLeftSlice.onClick();
            }
        }

        if (touchX > 0 && touchY < Math.tan(30f*Math.PI/180f)*touchX
                && touchY > -Math.tan(30f*Math.PI/180f)*touchX ){
            indexButton = BTN_WW;
            startBlinkingAnimation();
            if (onClickBottomLeftSlice != null) {
                onClickBottomLeftSlice.onClick();
            }
        }

        if (touchX < 0 && touchY < -Math.tan(30f*Math.PI/180f)*touchX
                && touchY > Math.tan(30f*Math.PI/180f)*touchX ){
            indexButton = BTN_EE;
            startBlinkingAnimation();
            if (onClickBottomRightSlice != null) {
                onClickBottomRightSlice.onClick();
            }
        }

    }

}
