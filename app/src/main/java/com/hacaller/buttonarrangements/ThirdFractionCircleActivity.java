package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hacaller.hac_2dbutton_arrangement.ThirdFractionCircle;

public class ThirdFractionCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_fraction_circle);

        ThirdFractionCircle view = (ThirdFractionCircle) findViewById(R.id.test01);

    }
}
