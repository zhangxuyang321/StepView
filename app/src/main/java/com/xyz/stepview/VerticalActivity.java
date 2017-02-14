package com.xyz.stepview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xyz.step.FlowViewVertical;

import static android.icu.lang.UCharacter.JoiningGroup.E;

public class VerticalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        FlowViewVertical vFlow = (FlowViewVertical) findViewById(R.id.vflow);
        vFlow.setProgress(9, 10, getResources().getStringArray(R.array.vflow), null);
    }
}
