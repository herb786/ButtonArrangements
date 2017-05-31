package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hacaller.hac_2dbutton_arrangement.HalfFractionCircle;

public class HalfFractionCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half_fraction_circle);

        HalfFractionCircle view = (HalfFractionCircle) findViewById(R.id.test01);

    }
}
