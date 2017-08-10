package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
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
 * Created by Herbert Caller on 30/05/2017.
 */

public class BaseShapeView extends View {

    public interface OnClickLeftSlice{
        void onClick();
    }

    public interface OnClickRightSlice{
        void onClick();
    }

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

    public interface OnClickMiddleBrick{
        void onClick();
    }

    public interface OnClickRightmostButton{
        void onClick();
    }

    public interface OnClickLeftmostButton{
        void onClick();
    }

    protected boolean isAnimationOn = false;
    protected static final int BTN_NN = 0;
    protected static final int BTN_NE = 1;
    protected static final int BTN_EE = 2;
    protected static final int BTN_SE = 3;
    protected static final int BTN_SS = 4;
    protected static final int BTN_SW = 5;
    protected static final int BTN_WW = 6;
    protected static final int BTN_NW = 7;

    protected OnClickTopSlice onClickTopSlice;
    protected OnClickBottomSlice onClikBottomSlice;
    protected OnClickLeftSlice onClickLeftSlice;
    protected OnClickRightSlice onClickRightSlice;
    protected OnClickTopRightSlice onClickTopRightSlice;
    protected OnClickTopLeftSlice onClickTopLeftSlice;
    protected OnClickBottomLeftSlice onClickBottomLeftSlice;
    protected OnClickBottomRightSlice onClickBottomRightSlice;
    protected OnClickMiddleBrick onClickMiddleBrick;
    protected OnClickLeftmostButton onClickLeftmostButton;
    protected OnClickRightmostButton onClickRightmostButton;

    protected float touchX, touchY;

    protected long originTime = System.currentTimeMillis();
    protected long elapsedTime;
    protected int superRadius = 120;
    protected int canvasLong;
    protected int canvasBroad;
    protected float outterRadius = 120f;
    protected float innerRadius = 0f;
    protected int[] initColors = new int[]{Color.RED, Color.BLUE, Color.GREEN, Color.DKGRAY,
            Color.YELLOW, Color.MAGENTA, Color.LTGRAY, Color.CYAN};
    protected int[] defColors = initColors.clone();
    protected String[] textButton = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    protected Path pathSrc, pathDst;
    protected RectF rectSrc, rectDst;
    protected int indexButton = -1;

    //Timer highTimer, lowTimer;

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
        // Set size to 360dp
        //int size = Math.round(360f * getResources().getDisplayMetrics().density);
        //setMeasuredDimension(size, size);

        int size = Math.round(240f * getResources().getDisplayMetrics().density);
        int desiredWidth = getMeasuredWidth() != 0 ? getMeasuredWidth() : size;
        int desiredHeight = desiredWidth;

        canvasBroad = resolveSize(desiredWidth, widthMeasureSpec);
        canvasLong = resolveSize(desiredHeight, heightMeasureSpec);

        superRadius = canvasBroad/2;
        outterRadius = 1f*superRadius;
        setMeasuredDimension(canvasBroad, canvasLong);
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

    protected Bitmap makeRect(RectF rectF, int color, int size){
        Bitmap bm = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(color);
        c.drawRect(rectF, p);
        return bm;
    }

    protected int lightenColour(int rgb){
        // hue, saturation, value
        float[] hsv = new float[3];
        Color.colorToHSV(rgb, hsv);
        hsv[2] *= .8f;
        return Color.HSVToColor(hsv);
    }

    protected void startButtonBlink(){
        /*
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
        */
    }

    protected void startBlinkingAnimation(){
        isAnimationOn = true;
        //Log.d("Animation on -->", String.valueOf(isAnimationOn));
        doBlinkingAnimation();
    }

    protected void doBlinkingAnimation(){
        if (isAnimationOn) {
            elapsedTime = System.currentTimeMillis() - originTime;
            //Log.d("elapsed time -->", String.valueOf(elapsedTime));
            if (elapsedTime > 0){
                long seconds = elapsedTime / 1000L;
                if ( seconds % 2 == 0){
                    defColors = Arrays.copyOf(initColors, initColors.length);
                    defColors[indexButton] = lightenColour(initColors[indexButton]);
                } else {
                    defColors = initColors.clone();
                }
                invalidate();
            }
        }
    }

    protected void stopBlinkingAnimation(){
        isAnimationOn = false;
        defColors = initColors.clone();
        invalidate();
        //Log.d("Animation on -->", String.valueOf(isAnimationOn));
    }


    protected void stopButtonBlink(){
        /*
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
        */
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

    public void setOnClickLeftSlice(OnClickLeftSlice onClickLeftSlice) {
        this.onClickLeftSlice = onClickLeftSlice;
    }

    public void setOnClickRightSlice(OnClickRightSlice onClickRightSlice) {
        this.onClickRightSlice = onClickRightSlice;
    }

    public void setOnClikBottomSlice(OnClickBottomSlice onClikBottomSlice) {
        this.onClikBottomSlice = onClikBottomSlice;
    }

    public void setOnClickMiddleBrick(OnClickMiddleBrick onClickMiddleBrick) {
        this.onClickMiddleBrick = onClickMiddleBrick;
    }

    public void setOnClickLeftmostButton(OnClickLeftmostButton onClickLeftmostButton) {
        this.onClickLeftmostButton = onClickLeftmostButton;
    }

    public void setOnClickRightmostButton(OnClickRightmostButton onClickRightmostButton) {
        this.onClickRightmostButton = onClickRightmostButton;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            touchX = event.getX()-superRadius;
            touchY = superRadius - event.getY();
            Log.d("Coordinates", String.format("x: %f, y: %f", touchX ,touchY));
            boolean inside = (touchX*touchX + touchY*touchY < outterRadius*outterRadius)
                    && (touchX*touchX + touchY*touchY > innerRadius*innerRadius);
            if ( inside ) {
                onTouchInsideSlice();
            } else {
                stopBlinkingAnimation();
                //stopButtonBlink();
            }
        }
        return true;
        //return super.onTouchEvent(event);
    }

    protected void onTouchInsideSlice(){
        //Log.d("Animation on -->", String.valueOf(isAnimationOn));
    }

    private Runnable updateRunnable = new Runnable() {
        @Override
        public void run() {
            updateBaseShapeView();
        }
    };

    public void updateBaseShapeView(){
        invalidate();
        postDelayed(updateRunnable, 200L);
    }

    public void stopBaseShapeViewUpdate(){
        removeCallbacks(updateRunnable);
    }

    public void startBaseShapeViewUpdate(){
        updateBaseShapeView();
    }




}
