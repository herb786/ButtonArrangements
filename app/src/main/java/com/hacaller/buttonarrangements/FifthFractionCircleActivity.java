package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hacaller.hac_2dbutton_arrangement.FifthFractionCircle;

public class FifthFractionCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_fraction_circle);

        FifthFractionCircle view = (FifthFractionCircle) findViewById(R.id.test01);

    }
}
