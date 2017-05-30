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

public class FourthFractionCircle extends View {

    public interface OnClickTopRightSlice{
        void onClick();
    };

    public interface OnClickTopLeftSlice{
        void onClick();
    };

    public interface OnClickBottomRightSlice{
        void onClick();
    };

    public interface OnClickBottomLeftSlice{
        void onClick();
    };

    private OnClickTopRightSlice onClickTopRightSlice;
    private OnClickTopLeftSlice onClickTopLeftSlice;
    private OnClickBottomLeftSlice onClickBottomLeftSlice;
    private OnClickBottomRightSlice onClickBottomRightSlice;

    private int superRadius = 120;
    private float outterRadius = 120f;
    private float innerRadius = 0f;
    private int[] initColors = new int[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    private int[] defColors = initColors.clone();
    private String[] textButton = new String[]{"A", "B", "C", "D"};
    private Path pathSrc, pathDst;
    private RectF rectSrc, rectDst;
    private int indexButton = -1;

    Timer highTimer, lowTimer;

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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width, height;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int desiredWidth = getMeasuredWidth();
        int desiredHeight = desiredWidth;


        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

        superRadius = width/2;
        outterRadius = 1f*superRadius;
        setMeasuredDimension(width, height);

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

    private Bitmap makeDst(Path path, int color, int size){
        Bitmap bm = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(color);
        c.drawPath(path, p);

        return bm;
    }

    private Bitmap makeSrc(Path path, int color, int size){
        Bitmap bm = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(color);
        c.drawPath(path, p);

        return bm;

    }

    public void setOnClickTopRightSlice(OnClickTopRightSlice onClickTopRightSlice) {
        this.onClickTopRightSlice = onClickTopRightSlice;
    }

    public void setOnClickTopLeftSlice(OnClickTopLeftSlice onClickTopLeftSlice) {
        this.onClickTopLeftSlice = onClickTopLeftSlice;
    }

    public void setOnClickBottomLeftSlice(OnClickBottomLeftSlice onClickBottomLeftSlice) {
        this.onClickBottomLeftSlice = onClickBottomLeftSlice;
    }

    public void setOnClickBottomRightSlice(OnClickBottomRightSlice onClickBottomRightSlice) {
        this.onClickBottomRightSlice = onClickBottomRightSlice;
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

    private int lightenColour(int rgb){
        // hue, saturation, value
        float[] hsv = new float[3];
        Color.colorToHSV(rgb, hsv);
        hsv[2] *= .9f;
        return Color.HSVToColor(hsv);
    }

    private void startButtonBlink(){
        if (highTimer != null){
            highTimer.cancel();
            highTimer.purge();
            highTimer = null;
        }
        if (lowTimer != null){
            lowTimer.cancel();
            lowTimer.purge();
            lowTimer = null;
        }
        highTimer = new Timer();
        lowTimer = new Timer();
        if (indexButton != -1){
            highTimer.scheduleAtFixedRate(new ButtonHighTask(),500, 500);
            lowTimer.scheduleAtFixedRate(new ButtonLowTask(),250, 500);
        }
    }

    private void stopButtonBlink(){
        if (highTimer != null){
            highTimer.cancel();
            highTimer.purge();
            highTimer = null;
        }
        if (lowTimer != null){
            lowTimer.cancel();
            lowTimer.purge();
            lowTimer = null;
        }
        defColors = initColors.clone();
        invalidate();
    }


    private class ButtonHighTask extends TimerTask{
        @Override
        public void run() {
            handler.obtainMessage(1).sendToTarget();
        }
    }

    private class ButtonLowTask extends TimerTask{
        @Override
        public void run() {
            handler.obtainMessage(2).sendToTarget();
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                defColors = Arrays.copyOf(initColors, initColors.length);
                defColors[indexButton] = lightenColour(initColors[indexButton]);
            } else {
                defColors = initColors.clone();
            }
            invalidate();
        }
    };

}
