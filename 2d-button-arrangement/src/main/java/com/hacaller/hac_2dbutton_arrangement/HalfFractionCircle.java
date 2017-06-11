package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.effect.Effect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by AGB on 31/05/2017.
 */

public class HalfFractionCircle extends BaseShapeView {

    public HalfFractionCircle(Context context) {
        super(context);
    }

    public HalfFractionCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HalfFractionCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("Current time -->", String.valueOf(System.currentTimeMillis()));
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
        drawLeftButton(canvas, paint);
        drawRightButton(canvas, paint);
        booleanDiffence(canvas, paint);
        paintSliceText(canvas, paint);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawLeftButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, 0f);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, -90f, -180f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_WW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawRightButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, 0f);
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathSrc.arcTo(rectF, -90f, 180f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, defColors[BTN_EE], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void booleanDiffence(Canvas canvas, Paint paint) {
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        float dx1 = outterRadius - innerRadius;
        Bitmap bmDst = makeCircleDst(defColors[3], (int) (2*innerRadius));
        canvas.drawBitmap(bmDst, dx1, dx1, paint);
        paint.setXfermode(null);
    }

    private void paintSliceText(Canvas canvas, Paint paint){
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.BLACK);
        //textPaint.setTextScaleX(1.2f);
        textPaint.setTextSize(150f);
        String mText = "H E L L O";
        Rect rect = new Rect();
        textPaint.getTextBounds(mText, 0, mText.length(), rect);
        Path path = new Path();
        RectF rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        path.addArc(rectF, 90f, -180f);
        canvas.drawTextOnPath(mText,path,outterRadius-rect.centerX(),0f+rect.centerY(),textPaint);

    }

    @Override
    protected void onTouchInsideSlice() {
        super.onTouchInsideSlice();
        if (touchX > 0){
            indexButton = BTN_EE;
            startBlinkingAnimation();
            if (onClickTopRightSlice != null){
                onClickTopRightSlice.onClick();
            }
        }
        if (touchX < 0 ){
            indexButton = BTN_WW;
            startBlinkingAnimation();
            if (onClickTopLeftSlice != null){
                onClickTopLeftSlice.onClick();
            }
        }
    }


}
