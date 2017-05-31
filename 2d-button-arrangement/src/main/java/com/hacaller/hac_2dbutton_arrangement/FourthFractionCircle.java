package com.hacaller.hac_2dbutton_arrangement;

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
        drawBottomRightButton(canvas, paint);
        drawBottomLeftButton(canvas, paint);
        canvas.restoreToCount(sc);
    }


    private void drawTopLeftButton(Canvas canvas, Paint paint){
        // Source image (src)
        pathSrc = new Path();
        float dx1 = outterRadius - innerRadius;
        float dx2 = outterRadius + innerRadius;
        pathSrc.moveTo(outterRadius, outterRadius);
        pathSrc.lineTo(outterRadius, dx1);
        RectF rectF = new RectF(dx1, dx1, dx2, dx2);
        pathSrc.arcTo(rectF, -90f, -90f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, Color.WHITE, superRadius);
        canvas.drawBitmap(bmSrc, 0, 0, paint);
        // Destination image (dst)
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        pathDst = new Path();
        pathDst.moveTo(outterRadius, outterRadius);
        pathDst.lineTo(outterRadius, 0f);
        rectF = new RectF(0f, 0f, 2*outterRadius, 2*outterRadius);
        pathDst.arcTo(rectF, -90f, -90f);
        pathDst.close();
        // Default: yellow
        Bitmap bmDst = makeDst(pathDst, defColors[3], superRadius);
        canvas.drawBitmap(bmDst, 0, 0, paint);
        paint.setXfermode(null);
    }


    private void drawTopRightButton(Canvas canvas, Paint paint){
        // Source image (src)
        pathSrc = new Path();
        float dx1 = outterRadius - innerRadius;
        float dx2 = outterRadius + innerRadius;
        pathSrc.moveTo(0f, outterRadius);
        pathSrc.lineTo(innerRadius, outterRadius);
        rectSrc = new RectF(-innerRadius, dx1, innerRadius, dx2);
        pathSrc.arcTo(rectSrc, 0f, -90f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, Color.WHITE, getWidth()/2);
        canvas.drawBitmap(bmSrc, outterRadius, 0f, paint);
        // Destination image (dst)
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        pathDst = new Path();
        pathDst.moveTo(0f, outterRadius);
        pathDst.lineTo(outterRadius, outterRadius);
        rectDst = new RectF(-outterRadius, 0f, outterRadius, 2*outterRadius);
        pathDst.arcTo(rectDst, 0f, -90f);
        pathDst.close();
        // Default: red
        Bitmap bmDst = makeDst(pathDst, defColors[0], superRadius);
        canvas.drawBitmap(bmDst, outterRadius, 0, paint);
        paint.setXfermode(null);
    }


    private void drawBottomRightButton(Canvas canvas, Paint paint){
        // Source image (src)
        pathSrc = new Path();
        pathSrc.moveTo(0f, 0f);
        pathSrc.lineTo(innerRadius, 0f);
        rectSrc = new RectF(-innerRadius, -innerRadius, innerRadius, innerRadius);
        pathSrc.arcTo(rectSrc, 0f, 90f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, Color.WHITE, superRadius);
        canvas.drawBitmap(bmSrc, outterRadius, outterRadius, paint);
        // Destination image (dst)
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        pathDst = new Path();
        pathDst.moveTo(0f, 0f);
        pathDst.lineTo(outterRadius, 0f);
        rectDst = new RectF(-outterRadius, -outterRadius, outterRadius, outterRadius);
        pathDst.arcTo(rectDst, 0f, 90f);
        pathDst.close();
        // Default: blue
        Bitmap bmDst = makeDst(pathDst, defColors[1], superRadius);
        canvas.drawBitmap(bmDst, outterRadius, outterRadius, paint);
        paint.setXfermode(null);
    }


    private void drawBottomLeftButton(Canvas canvas, Paint paint){
        // Source image (src)
        pathSrc = new Path();
        float dx1 = outterRadius - innerRadius;
        float dx2 = outterRadius + innerRadius;
        pathSrc.moveTo(outterRadius, 0f);
        pathSrc.lineTo(outterRadius, dx1);
        rectSrc = new RectF(dx1, -innerRadius, dx2, innerRadius);
        pathSrc.arcTo(rectSrc, 90f, 90f);
        pathSrc.close();
        Bitmap bmSrc = makeSrc(pathSrc, Color.WHITE, superRadius);
        canvas.drawBitmap(bmSrc, 0f, outterRadius, paint);
        // Destination image (dst)
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        pathDst = new Path();
        pathDst.moveTo(outterRadius, 0f);
        pathDst.lineTo(outterRadius, outterRadius);
        rectDst = new RectF(0f, -outterRadius, 2*outterRadius, outterRadius);
        pathDst.arcTo(rectDst, 90f, 90f);
        pathDst.close();
        //Default: green
        Bitmap bmDst = makeDst(pathDst, defColors[2], superRadius);
        canvas.drawBitmap(bmDst, 0f, outterRadius, paint);
        paint.setXfermode(null);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            float x = event.getX()-superRadius;
            float y = superRadius - event.getY();
            Log.d("Coordinates", String.format("x: %f, y: %f", x ,y));
            boolean inside = (x*x + y*y < outterRadius*outterRadius)
                    && (x*x + y*y > innerRadius*innerRadius);
            if ( inside ) {
                if (x > 0 && y > 0){
                    indexButton = 0;
                    startButtonBlink();
                    if (onClickTopRightSlice != null){
                        onClickTopRightSlice.onClick();
                    }
                }
                if (x < 0 && y > 0){
                    indexButton = 3;
                    startButtonBlink();
                    if (onClickTopLeftSlice != null){
                        onClickTopLeftSlice.onClick();
                    }
                }
                if (x < 0 && y < 0){
                    indexButton = 2;
                    startButtonBlink();
                    if (onClickBottomLeftSlice != null) {
                        onClickBottomLeftSlice.onClick();
                    }
                }
                if (x > 0 && y < 0){
                    indexButton = 1;
                    startButtonBlink();
                    if (onClickBottomRightSlice != null) {
                        onClickBottomRightSlice.onClick();
                    }
                }
            } else {
                stopButtonBlink();
            }
        }
        return true;
        //return super.onTouchEvent(event);
    }



}
