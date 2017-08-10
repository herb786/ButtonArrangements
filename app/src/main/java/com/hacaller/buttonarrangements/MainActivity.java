package com.hacaller.buttonarrangements;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hacaller.hac_2dbutton_arrangement.FourthFractionCircle;
import com.hacaller.hac_2dbutton_arrangement.SixthFractionCircle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button threeBtn = (Button) findViewById(R.id.three_slices);
        Button fourBtn = (Button) findViewById(R.id.four_slices);
        Button fiveBtn = (Button) findViewById(R.id.five_slices);
        Button twoBtn = (Button) findViewById(R.id.two_slices);
        Button sixBtn = (Button) findViewById(R.id.six_slices);
        Button checkerBtn = (Button) findViewById(R.id.checker);
        Button measureBtn = (Button) findViewById(R.id.measures);

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThirdFractionCircleActivity.class));
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FourthFractionCircleActivity.class));
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FifthFractionCircleActivity.class));
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HalfFractionCircleActivity.class));
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SixthFractionCircleActivity.class));
            }
        });

        checkerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FiveBoxCheckerActivity.class));
            }
        });

        measureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
            }
        });

    }
}
