package com.hacaller.hac_2dbutton_arrangement;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseRectEventView extends View {

    protected final int BTN_A = 0;
    protected final int BTN_B = 1;
    protected final int BTN_C = 2;
    protected final int BTN_D = 3;
    protected final int BTN_E = 4;
    protected final int BTN_F = 5;

    public BaseRectEventView(Context context) {
        super(context);
        this.setDrawingCacheEnabled(true);
    }

    public BaseRectEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setDrawingCacheEnabled(true);
    }

    public BaseRectEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setDrawingCacheEnabled(true);
    }

    public interface OnClickButtonA {
        void onClick();
    }

    public interface OnClickButtonB {
        void onClick();
    }

    public interface OnClickButtonC {
        void onClick();
    }

    public interface OnClickButtonD {
        void onClick();
    }

    public interface OnClickButtonE {
        void onClick();
    }

    public interface OnClickButtonF {
        void onClick();
    }

    protected OnClickButtonA onClickButtonA;
    protected OnClickButtonB onClickButtonB;
    protected OnClickButtonC onClickButtonC;
    protected OnClickButtonD onClickButtonD;
    protected OnClickButtonE onClickButtonE;
    protected OnClickButtonF onClickButtonF;


    public void setOnClickButtonA(OnClickButtonA onClickButtonA) {
        this.onClickButtonA = onClickButtonA;
    }

    public void setOnClickButtonB(OnClickButtonB onClickButtonB) {
        this.onClickButtonB = onClickButtonB;
    }

    public void setOnClickButtonC(OnClickButtonC onClickButtonC) {
        this.onClickButtonC = onClickButtonC;
    }

    public void setOnClickButtonD(OnClickButtonD onClickButtonD) {
        this.onClickButtonD = onClickButtonD;
    }

    public void setOnClickButtonE(OnClickButtonE onClickButtonE) {
        this.onClickButtonE = onClickButtonE;
    }

    public void setOnClickButtonF(OnClickButtonF onClickButtonF) {
        this.onClickButtonF = onClickButtonF;
    }

}
