package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hacaller.hac_2dbutton_arrangement.SixthFractionCircle;

public class SixthFractionCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_fraction_circle);

        SixthFractionCircle view = (SixthFractionCircle) findViewById(R.id.test01);

    }
}
