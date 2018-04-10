package com.hacaller.hac_2dbutton_arrangement.CircleSector;

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

import com.hacaller.hac_2dbutton_arrangement.BaseShapeView;

/**
 * Created by Herbert Caller on 31/05/2017.
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
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        innerRadius = 0.5f*outterRadius;
        drawLeftButton(canvas);
        drawRightButton(canvas);
        booleanDifference(canvas);
        //paintSliceText(canvas, paint);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 256.52917,511.72354", pathSrc, 1f);
        pathSrc = drawSvgPath("C 115.38799,511.72354 -5.7202626,397.90001 0.0467967,256.75881 -5.7202626,117.13527 114.24974,0.69379 255.39093,0.27644", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_WW], pathSrc);
    }

    private void drawRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        pathSrc = drawSvgPath("M 255.47083,0.27647", pathSrc, 1f);
        pathSrc = drawSvgPath("C 396.612,0.27647 517.72026,114.1 511.9532,255.24119 517.72026,394.86473 397.75025,511.30622 256.60907,511.72357", pathSrc, 1f);
        pathSrc.close();
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_EE], pathSrc);
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
    }


}
