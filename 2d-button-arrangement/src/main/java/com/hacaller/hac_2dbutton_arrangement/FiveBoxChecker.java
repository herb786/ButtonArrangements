package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by herbert on 11/06/2017.
 */

public class FiveBoxChecker extends BaseShapeView {

    private float unitLength;

    public FiveBoxChecker(Context context) {
        super(context);
    }

    public FiveBoxChecker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FiveBoxChecker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        unitLength = 2*superRadius/3f;
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

        drawTopLeftButton(canvas, paint);
        drawTopRightButton(canvas, paint);
        drawMiddleButton(canvas, paint);
        drawBottomLeftButton(canvas, paint);
        drawBottomRightButton(canvas, paint);

        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopLeftButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        RectF rectF = new RectF(0f, 0f, unitLength, unitLength);
        Bitmap bmSrc = makeRect(rectF, defColors[BTN_NW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawTopRightButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        RectF rectF = new RectF(2*unitLength, 0f, 3*unitLength, unitLength);
        Bitmap bmSrc = makeRect(rectF, defColors[BTN_NE], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawMiddleButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        RectF rectF = new RectF(unitLength, unitLength, 2*unitLength, 2*unitLength);
        Bitmap bmSrc = makeRect(rectF, defColors[BTN_WW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawBottomLeftButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        RectF rectF = new RectF(0f, 2*unitLength, unitLength, 3*unitLength);
        Bitmap bmSrc = makeRect(rectF, defColors[BTN_SW], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    private void drawBottomRightButton(Canvas canvas, Paint paint) {
        pathSrc = new Path();
        RectF rectF = new RectF(2*unitLength, 2*unitLength, 3*unitLength, 3*unitLength);
        Bitmap bmSrc = makeRect(rectF, defColors[BTN_SE], 2*superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
    }

    @Override
    protected void onTouchInsideSlice() {
        super.onTouchInsideSlice();
        if (touchX > -unitLength/2f && touchX < unitLength/2f
                && touchY > -unitLength/2f && touchY < unitLength/2f){
            indexButton = BTN_WW;
            startBlinkingAnimation();
            if (onClickMiddleBrick != null){
                onClickMiddleBrick.onClick();
            }
        }
        if (touchX > -3*unitLength/2f && touchX < -unitLength/2f
                && touchY > unitLength/2f && touchY < 3*unitLength/2f){
            indexButton = BTN_NW;
            startBlinkingAnimation();
            if (onClickTopLeftSlice != null){
                onClickTopLeftSlice.onClick();
            }
        }
        if (touchX > unitLength/2f && touchX < 3*unitLength/2f
                && touchY > unitLength/2f && touchY < 3*unitLength/2f){
            indexButton = BTN_NE;
            startBlinkingAnimation();
            if (onClickTopRightSlice != null){
                onClickTopRightSlice.onClick();
            }
        }
        if (touchX > -3*unitLength/2f && touchX < -unitLength/2f
                && touchY < -unitLength/2f && touchY > -3*unitLength/2f){
            indexButton = BTN_SW;
            startBlinkingAnimation();
            if (onClickBottomLeftSlice != null){
                onClickBottomLeftSlice.onClick();
            }
        }
        if (touchX > unitLength/2f && touchX < 3*unitLength/2f
                && touchY < -unitLength/2f && touchY > -3*unitLength/2f){
            indexButton = BTN_SE;
            startBlinkingAnimation();
            if (onClickBottomRightSlice != null){
                onClickBottomRightSlice.onClick();
            }
        }

    }

}
