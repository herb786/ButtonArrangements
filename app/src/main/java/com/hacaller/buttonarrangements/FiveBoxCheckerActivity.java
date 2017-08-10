package com.hacaller.buttonarrangements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hacaller.hac_2dbutton_arrangement.FiveBoxChecker;

public class FiveBoxCheckerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_box_checker);

        FiveBoxChecker view = (FiveBoxChecker) findViewById(R.id.test01);

    }
}
