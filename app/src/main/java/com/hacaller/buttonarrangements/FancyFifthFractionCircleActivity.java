package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hacaller.hac_2dbutton_arrangement.FancyFifthFractionCircle;

public class FancyFifthFractionCircleActivity extends AppCompatActivity {

    FancyFifthFractionCircle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_fifth_fraction_circle);

        circle = (FancyFifthFractionCircle) findViewById(R.id.test01);
        circle.setGrayColors();
        circle.setEnabled(false);
        circle.shuffleLetters();
    }
}
