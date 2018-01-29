package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hacaller.hac_2dbutton_arrangement.FancyFifthFractionCircle;
import com.hacaller.hac_2dbutton_arrangement.FancyThirdFractionCircle;

public class FancyThirdFractionCircleActivity extends AppCompatActivity {

    FancyThirdFractionCircle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_third_fraction_circle);

        circle = (FancyThirdFractionCircle) findViewById(R.id.test01);
        //circle.setGrayColors();
        //circle.setEnabled(false);
    }
}
