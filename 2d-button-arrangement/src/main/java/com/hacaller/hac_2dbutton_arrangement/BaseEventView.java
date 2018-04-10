package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseEventView extends View {

    protected final int BTN_OO = 0;
    protected final int BTN_NN = 1;
    protected final int BTN_NE = 2;
    protected final int BTN_EE = 3;
    protected final int BTN_SE = 4;
    protected final int BTN_SS = 5;
    protected final int BTN_SW = 6;
    protected final int BTN_WW = 7;
    protected final int BTN_NW = 8;


    public BaseEventView(Context context) {
        super(context);
        this.setDrawingCacheEnabled(true);
    }

    public BaseEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setDrawingCacheEnabled(true);
    }

    public BaseEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setDrawingCacheEnabled(true);
    }

    public interface OnClickSectorOO {
        void onClick();
    }

    public interface OnClickSectorNN {
        void onClick();
    }

    public interface OnClickSectorNE {
        void onClick();
    }

    public interface OnClickSectorEE {
        void onClick();
    }

    public interface OnClickSectorSE {
        void onClick();
    }

    public interface OnClickSectorSS {
        void onClick();
    }

    public interface OnClickSectorSW {
        void onClick();
    }

    public interface OnClickSectorWW {
        void onClick();
    }

    public interface OnClickSectorNW {
        void onClick();
    }


    protected OnClickSectorNN onClickSectorNN;
    protected OnClickSectorOO onClickSectorOO;
    protected OnClickSectorNE onClickSectorNE;
    protected OnClickSectorEE onClickSectorEE;
    protected OnClickSectorSE onClickSectorSE;
    protected OnClickSectorSS onClickSectorSS;
    protected OnClickSectorSW onClickSectorSW;
    protected OnClickSectorWW onClickSectorWW;
    protected OnClickSectorNW onClickSectorNW;


    public void setOnClickSectorOO(OnClickSectorOO onClickSectorOO) {
        this.onClickSectorOO = onClickSectorOO;
    }

    public void setOnClickSectorNN(OnClickSectorNN onClickSectorNN) {
        this.onClickSectorNN = onClickSectorNN;
    }

    public void setOnClickSectorNE(OnClickSectorNE onClickSectorNE) {
        this.onClickSectorNE = onClickSectorNE;
    }

    public void setOnClickSectorEE(OnClickSectorEE onClickSectorEE) {
        this.onClickSectorEE = onClickSectorEE;
    }

    public void setOnClickSectorSE(OnClickSectorSE onClickSectorSE) {
        this.onClickSectorSE = onClickSectorSE;
    }

    public void setOnClickSectorSS(OnClickSectorSS onClickSectorSS) {
        this.onClickSectorSS = onClickSectorSS;
    }

    public void setOnClickSectorSW(OnClickSectorSW onClickSectorSW) {
        this.onClickSectorSW = onClickSectorSW;
    }

    public void setOnClickSectorWW(OnClickSectorWW onClickSectorWW) {
        this.onClickSectorWW = onClickSectorWW;
    }

    public void setOnClickSectorNW(OnClickSectorNW onClickSectorNW) {
        this.onClickSectorNW = onClickSectorNW;
    }

}
