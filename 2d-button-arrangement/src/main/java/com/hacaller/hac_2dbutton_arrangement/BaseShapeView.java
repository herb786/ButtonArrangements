package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;

import org.xmlpull.v1.XmlPullParser;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Herbert Caller on 30/05/2017.
 */

public class BaseShapeView extends BaseEventView {

    protected boolean isAnimationOn = false;

    protected float touchX, touchY;
    protected float eventX, eventY;
    protected Bitmap finalBitmap;

    protected final int FIREBRICK = 0xFFB22222;
    protected final int CORAL = 0xFFFF7F50;
    protected final int KHAKI = 0xFFF0E68C;
    protected final int THISTLE = 0xFFD8BFD8;
    protected final int PALEGREEN = 0xFF98FB98;
    protected final int DARKSEAGREEN = 0xFF8FBC8B;
    protected final int POWDERBLUE = 0xFFB0E0E6;
    protected final int WHEAT = 0xFFF5DEB3;
    protected final int ROSYBROWN = 0xFFBC8F8F;

    protected float sourceSizeX = 512f;
    protected float sourceSizeY = 512f;
    protected long originTime = System.currentTimeMillis();
    protected long elapsedTime;
    protected int superRadius = 120;
    protected int canvasLong;
    protected int canvasBroad;
    protected float outterRadius = 120f;
    protected float innerRadius = 0f;
    protected int[] initColors = new int[]{FIREBRICK, CORAL, KHAKI, THISTLE, PALEGREEN,
            DARKSEAGREEN, POWDERBLUE, WHEAT, ROSYBROWN};
    protected int[] defColors = initColors.clone();
    protected String[] textButton = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    protected Path pathSrc;
    protected float lastX, lastY;
    protected int indexButton = -1;



    //Timer highTimer, lowTimer;

    public BaseShapeView(Context context) {
        super(context);
        this.setDrawingCacheEnabled(true);
    }

    public BaseShapeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setDrawingCacheEnabled(true);
    }

    public BaseShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setDrawingCacheEnabled(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = Math.round(240f * getResources().getDisplayMetrics().density);
        int desiredWidth = getMeasuredWidth() != 0 ? getMeasuredWidth() : size;
        int desiredHeight = desiredWidth;

        canvasBroad = resolveSize(desiredWidth, widthMeasureSpec);
        canvasLong = resolveSize(desiredHeight, heightMeasureSpec);

        superRadius = canvasBroad/2;
        outterRadius = 1f*superRadius;
        finalBitmap = Bitmap.createBitmap(canvasBroad, canvasBroad, Bitmap.Config.ARGB_8888);
        setMeasuredDimension(canvasBroad, canvasLong);
    }

    protected Path drawClosedPathWithSrc(Path pathSrc, float scale, String srcString){
        String pathString = "";
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(srcString);
        m.find();
        int idx = m.start();
        while(m.find()){
            pathString = srcString.substring(idx, m.start()).trim();
            pathSrc = drawSvgPath(pathString, pathSrc, scale);
            idx = m.start();
        }
        pathSrc.close();
        return pathSrc;
    }


    protected void drawColorPathBitmap(Canvas canvas, float left, float top, int color, Path pathSrc){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setColor(color);
        canvas.drawPath(pathSrc, paint);
        canvas.drawBitmap(finalBitmap, left, top, paint);
    }

    protected void drawColorRectBitmap(Canvas canvas, String rect, int color){
        float scale = canvasBroad / sourceSizeX;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setColor(color);
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(new ByteArrayInputStream(rect.getBytes()), null);
            parser.nextTag();
            float x = scale*Float.parseFloat(parser.getAttributeValue(null, "x"));
            float y = scale*Float.parseFloat(parser.getAttributeValue(null, "y"));
            float height = scale*Float.parseFloat(parser.getAttributeValue(null, "height"));
            float width = scale*Float.parseFloat(parser.getAttributeValue(null, "width"));
            canvas.drawRect(x, y, x + width, y+ height, paint);
            canvas.drawBitmap(finalBitmap, 0, 0, paint);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected int lightenColour(int rgb){
        // hue, saturation, value
        float[] hsv = new float[3];
        Color.colorToHSV(rgb, hsv);
        hsv[2] *= .8f;
        return Color.HSVToColor(hsv);
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

    public boolean isSameColor(int color){
        Bitmap cacheBitmap = this.getDrawingCache();
        int width = cacheBitmap.getWidth();
        float scale = width/(1f*canvasBroad);
        int xCoord = (int) (eventX*scale);
        int yCoord = (int) (eventY*scale);
        int pixelColor = cacheBitmap.getPixel(xCoord, yCoord);
        if (pixelColor == color)
            return true;
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            eventX = event.getX();
            eventY = event.getY();
            touchX = eventX - superRadius;
            touchY = superRadius - eventY;
            onTouchColour();
            Log.d("Coordinates", String.format("x: %f, y: %f", touchX ,touchY));
            boolean inside = (touchX*touchX + touchY*touchY < outterRadius*outterRadius)
                    && (touchX*touchX + touchY*touchY > innerRadius*innerRadius);
            if ( inside ) {
                onTouchInsideSlice();
            } else {
                stopBlinkingAnimation();
            }
        }
        return true;
    }

    protected void onTouchInsideSlice(){
        //Log.d("Animation on -->", String.valueOf(isAnimationOn));
    }

    protected void onTouchColour(){

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


    public float getCoord(String coord){
        return 2f*Float.parseFloat(coord)*outterRadius/ sourceSizeX;
    }

    public Path drawSvgPath(String pathString, Path path, float scale) {
        if (pathString.charAt(0) == 'M') {
            pathString = pathString.replace("M", "").trim();
            String[] c = pathString.split(" ");
            String[] d = c[0].split(",");
            lastX = getCoord(d[0], scale);
            lastY = getCoord(d[1], scale);
            path.moveTo(lastX, lastY);
            if (c.length>1){
                for (int i = 1; i < c.length; i++) {
                    String[] d1 = c[i].split(",");
                    lastX = getCoord(d1[0], scale);
                    lastY = getCoord(d1[1], scale);
                    path.lineTo(lastX, lastY);
                }
            }

        } else if (pathString.charAt(0) == 'C') {
            pathString = pathString.replace("C", "").trim();
            String[] c = pathString.split(" ");
            for (int i = 0; i < c.length; i = i + 3) {
                String[] d1 = c[i].split(",");
                String[] d2 = c[i + 1].split(",");
                String[] d3 = c[i + 2].split(",");
                lastX = getCoord(d1[0], scale);
                lastY = getCoord(d1[1], scale);
                path.cubicTo(lastX, lastY,
                        getCoord(d2[0], scale), getCoord(d2[1], scale),
                        getCoord(d3[0], scale), getCoord(d3[1], scale));
            }
        } else if (pathString.charAt(0) == 'L') {
            pathString = pathString.replace("L", "").trim();
            String[] c = pathString.split(" ");
            for (int i = 0; i < c.length; i++) {
                String[] d1 = c[i].split(",");
                lastX = getCoord(d1[0], scale);
                lastY = getCoord(d1[1], scale);
                path.lineTo(lastX, lastY);
            }
        } else if (pathString.charAt(0) == 'm') {
            pathString = pathString.replace("m", "").trim();
            String[] c = pathString.split(" ");
            String[] d = c[0].split(",");
            path.rMoveTo(getCoord(d[0], scale),
                    getCoord(d[1], scale));
            if (c.length>1){
                for (int i = 1; i < c.length; i++) {
                    String[] d1 = c[i].split(",");
                    path.rLineTo(getCoord(d1[0], scale), getCoord(d1[1], scale));
                }
            }
        } else if (pathString.charAt(0) == 'c') {
            pathString = pathString.replace("c", "").trim();
            String[] c = pathString.split(" ");
            for (int i = 0; i < c.length; i = i + 3) {
                String[] d1 = c[i].split(",");
                String[] d2 = c[i + 1].split(",");
                String[] d3 = c[i + 2].split(",");
                path.rCubicTo(getCoord(d1[0], scale), getCoord(d1[1], scale),
                        getCoord(d2[0], scale), getCoord(d2[1], scale),
                        getCoord(d3[0], scale), getCoord(d3[1], scale));
            }
        } else if (pathString.charAt(0) == 'l') {
            pathString = pathString.replace("l", "").trim();
            String[] c = pathString.split(" ");
            for (int i = 0; i < c.length; i++) {
                String[] d1 = c[i].split(",");
                path.rLineTo(getCoord(d1[0], scale), getCoord(d1[1], scale));
            }
        } else if (pathString.charAt(0) == 'q') {
            pathString = pathString.replace("q", "").trim();
            String[] c = pathString.split(" ");
            for (int i = 0; i < c.length; i = i + 2) {
                String[] d1 = c[i].split(",");
                String[] d2 = c[i + 1].split(",");
                path.rQuadTo(getCoord(d1[0], scale), getCoord(d1[1], scale),
                        getCoord(d2[0], scale), getCoord(d2[1], scale));
            }
        } else if (pathString.charAt(0) == 'Q') {
            pathString = pathString.replace("Q", "").trim();
            String[] c = pathString.split(" ");
            for (int i = 0; i < c.length; i = i + 2) {
                String[] d1 = c[i].split(",");
                String[] d2 = c[i + 1].split(",");
                lastX = getCoord(d1[0], scale);
                lastY = getCoord(d1[1], scale);
                path.quadTo(lastX, lastY,
                        getCoord(d2[0], scale), getCoord(d2[1], scale));
            }
        } else if (pathString.charAt(0) == 'H') {
            pathString = pathString.replace("H", "").trim();
            lastX = getCoord(pathString, scale);
            path.lineTo(lastX, lastY);
        } else if (pathString.charAt(0) == 'V') {
            pathString = pathString.replace("V", "").trim();
            lastY = getCoord(pathString, scale);
            path.lineTo(lastX, lastY);
        }
        return path;
    }


    public float getCoord(String coord, float scale) {
        return scale * Float.parseFloat(coord) * canvasBroad / sourceSizeX;
    }

    public void clearCoords(){
        lastX = 0f;
        lastY = 0f;
    }

}
