package com.hacaller.buttonarrangements;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hacaller.hac_2dbutton_arrangement.CircleSector.HalfFractionCircle;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);


        HalfFractionCircle view1 = (HalfFractionCircle) findViewById(R.id.test01);
        HalfFractionCircle view2 = (HalfFractionCircle) findViewById(R.id.test02);
        HalfFractionCircle view3 = (HalfFractionCircle) findViewById(R.id.test03);
        HalfFractionCircle view4 = (HalfFractionCircle) findViewById(R.id.test04);
    }
}
