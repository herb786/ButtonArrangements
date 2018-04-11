package com.hacaller.hac_2dbutton_arrangement.Fours;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.hacaller.hac_2dbutton_arrangement.BaseShapeView;

/**
 * Created by herbert on 11/06/2017.
 */

public class FourDrops extends BaseShapeView {
    public FourDrops(Context context) {
        super(context);
    }

    public FourDrops(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourDrops(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getWidth(), null,
                Canvas.ALL_SAVE_FLAG);
        // Source image (src)
        drawTopRightButton(canvas);
        drawTopLeftButton(canvas);
        drawBottomRightButton(canvas);
        drawBottomLeftButton(canvas);
        canvas.restoreToCount(sc);
        doBlinkingAnimation();
    }

    private void drawTopRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 459.60241,172.90727 C 459.60241,215.08293 426.77893,256.43275 369.70851,255.99658 312.6381,255.5604 279.50709,215.08293 279.81463,172.0583 280.43684,85.01577 366.94081,90.37159 369.70851,0 372.47623,91.22056 459.60241,85.01409 459.60241,172.90727 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NE], pathSrc);
    }

    private void drawTopLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 232.18748,172.90726 C 232.18748,215.08292 199.364,256.43274 142.29359,255.99657 85.223179,255.56039 52.092155,215.08292 52.399707,172.05829 53.02191,85.01576 139.52589,90.37159 142.29359,0 145.06131,91.22055 232.18748,85.01408 232.18748,172.90726 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_NW], pathSrc);
    }

    private void drawBottomRightButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 459.60241,428.90727 C 459.60241,471.08293 426.77893,512.43275 369.70851,511.99658 312.6381,511.5604 279.50709,471.08293 279.81463,428.0583 280.43684,341.01576 366.94081,346.37158 369.70851,255.99999 372.47623,347.22055 459.60241,341.01408 459.60241,428.90727 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SE], pathSrc);
    }


    private void drawBottomLeftButton(Canvas canvas) {
        clearCoords();
        pathSrc = new Path();
        String srcString = "M 232.18748,428.90727 C 232.18748,471.08293 199.364,512.43275 142.29359,511.99658 85.223179,511.5604 52.092155,471.08293 52.399707,428.0583 53.02191,341.01577 139.52589,346.37159 142.29359,256 145.06131,347.22056 232.18748,341.01409 232.18748,428.90727 Z";
        pathSrc = drawClosedPathWithSrc(pathSrc, 1f, srcString);
        drawColorPathBitmap(canvas, 0, 0, defColors[BTN_SW], pathSrc);
    }



    @Override
    protected void onTouchColour() {
        super.onTouchColour();
        if (isSameColor(defColors[BTN_SW])){
            indexButton = BTN_SW;
            startBlinkingAnimation();
            if (onClickSectorSW != null){
                onClickSectorSW.onClick();
            }
        }
        if (isSameColor(defColors[BTN_SE])){
            indexButton = BTN_SE;
            startBlinkingAnimation();
            if (onClickSectorSE != null){
                onClickSectorSE.onClick();
            }
        }
        if (isSameColor(defColors[BTN_NW])){
            indexButton = BTN_NW;
            startBlinkingAnimation();
            if (onClickSectorNW != null){
                onClickSectorNW.onClick();
            }
        }
        if (isSameColor(defColors[BTN_NE])){
            indexButton = BTN_NE;
            startBlinkingAnimation();
            if (onClickSectorNE != null){
                onClickSectorNE.onClick();
            }
        }
    }

}
