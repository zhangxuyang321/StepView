package com.xyz.stepview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xyz.step.FlowViewHorizontal;
import com.xyz.step.FlowViewVertical;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlowViewHorizontal hFlow = (FlowViewHorizontal) findViewById(R.id.hflowview);
        FlowViewVertical vFlow = (FlowViewVertical) findViewById(R.id.vflowview);

        Map<String,String> map = new HashMap<>();
        map.put("异常","#FF0000");


        hFlow.setProgress(4, 4, getResources().getStringArray(R.array.hflow), getResources().getStringArray(R.array.htime));
        hFlow.setKeyColor(map);

        vFlow.setProgress(7,7,getResources().getStringArray(R.array.vflow),null);
        vFlow.setKeyColor(map);
    }
}
