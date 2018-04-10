package com.hacaller.buttonarrangements;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hacaller.hac_2dbutton_arrangement.CircleSector.FancyFifthFractionCircle;
import com.hacaller.hac_2dbutton_arrangement.CircleSector.FancyThirdFractionCircle;
import com.hacaller.hac_2dbutton_arrangement.CircleSector.FifthFractionCircle;
import com.hacaller.hac_2dbutton_arrangement.CircleSector.FourthFractionCircle;

public class MainActivity extends AppCompatActivity {

    FancyThirdFractionCircle circle;
    FancyFifthFractionCircle circle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle2 = (FancyFifthFractionCircle) findViewById(R.id.test01);
        circle2.setGrayColors();
        circle2.setEnabled(false);
        circle2.shuffleLetters();

        circle = (FancyThirdFractionCircle) findViewById(R.id.test02);

        FifthFractionCircle view = (FifthFractionCircle) findViewById(R.id.test03);
        FourthFractionCircle view2 = (FourthFractionCircle) findViewById(R.id.test04);

    }
}
