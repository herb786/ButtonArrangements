package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Herbert Caller on 30/05/2017.
 */

public class BaseShapeView extends View {

    public interface OnClickTopSlice{
        void onClick();
    }

    public interface OnClickBottomSlice{
        void onClick();
    }

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

    protected OnClickTopSlice onClickTopSlice;
    protected OnClickBottomSlice onClikBottomSlice;
    protected OnClickTopRightSlice onClickTopRightSlice;
    protected OnClickTopLeftSlice onClickTopLeftSlice;
    protected OnClickBottomLeftSlice onClickBottomLeftSlice;
    protected OnClickBottomRightSlice onClickBottomRightSlice;

    protected int superRadius = 120;
    protected float outterRadius = 120f;
    protected float innerRadius = 0f;
    protected int[] initColors = new int[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
    protected int[] defColors = initColors.clone();
    protected String[] textButton = new String[]{"A", "B", "C", "D", "E"};
    protected Path pathSrc, pathDst;
    protected RectF rectSrc, rectDst;
    protected int indexButton = -1;

    Timer highTimer, lowTimer;

    public BaseShapeView(Context context) {
        super(context);
    }

    public BaseShapeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

    protected Bitmap makeDst(Path path, int color, int size){
        Bitmap bm = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(color);
        c.drawPath(path, p);

        return bm;
    }

    protected Bitmap makeCircleDst(int color, int size){
        Bitmap bm = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(color);
        c.drawCircle(innerRadius, innerRadius, innerRadius, p);

        return bm;
    }

    protected Bitmap makeSrc(Path path, int color, int size){
        Bitmap bm = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(color);
        c.drawPath(path, p);

        return bm;

    }

    protected int lightenColour(int rgb){
        // hue, saturation, value
        float[] hsv = new float[3];
        Color.colorToHSV(rgb, hsv);
        hsv[2] *= .9f;
        return Color.HSVToColor(hsv);
    }

    protected void startButtonBlink(){
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

    protected void stopButtonBlink(){
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


    private class ButtonHighTask extends TimerTask {
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

    public void setOnClickTopSlice(OnClickTopSlice onClickTopSlice) {
        this.onClickTopSlice = onClickTopSlice;
    }

    public void setOnClickBottomSlice(OnClickBottomSlice onClickBottomSlice) {
        this.onClikBottomSlice = onClikBottomSlice;
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



}
