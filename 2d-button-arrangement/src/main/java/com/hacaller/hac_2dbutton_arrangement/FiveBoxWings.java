package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by herbert on 11/06/2017.
 */

public class FiveBoxWings extends BaseShapeView {

    private float unitLong;
    private float unitBroad;

    public FiveBoxWings(Context context) {
        super(context);
    }

    public FiveBoxWings(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FiveBoxWings(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        canvasLong = canvasBroad/2;
        setMeasuredDimension(canvasBroad, canvasLong);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        unitLong = canvasLong/3f;
        unitBroad = canvasBroad/5f;
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

        drawLeftmostButton(canvas, paint);
        drawRightmostButton(canvas, paint);
        drawMiddleButton(canvas, paint);
        drawLeftButton(canvas, paint);
        drawRightButton(canvas, paint);

        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawLeftmostButton(Canvas canvas, Paint paint) {

    }

    private void drawRightmostButton(Canvas canvas, Paint paint) {

    }

    private void drawMiddleButton(Canvas canvas, Paint paint) {

    }

    private void drawLeftButton(Canvas canvas, Paint paint) {

    }

    private void drawRightButton(Canvas canvas, Paint paint) {

    }

}
