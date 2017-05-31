package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hacaller.hac_2dbutton_arrangement.FourthFractionCircle;

public class FourthFractionCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_fraction_circle);

        FourthFractionCircle view = (FourthFractionCircle) findViewById(R.id.test01);


    }
}
