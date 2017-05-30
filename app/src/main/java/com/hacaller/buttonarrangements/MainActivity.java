package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hacaller.hac_2dbutton_arrangement.FourthFractionCircle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FourthFractionCircle view = (FourthFractionCircle) findViewById(R.id.test01);


    }
}
