package com.xyz.stepview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xyz.step.FlowViewHorizontal;
import com.xyz.step.FlowViewVertical;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlowViewHorizontal hFlow3 = (FlowViewHorizontal) findViewById(R.id.hflowview3);
        FlowViewHorizontal hFlow4 = (FlowViewHorizontal) findViewById(R.id.hflowview4);
        FlowViewHorizontal hFlow5 = (FlowViewHorizontal) findViewById(R.id.hflowview5);
        FlowViewHorizontal hFlow6 = (FlowViewHorizontal) findViewById(R.id.hflowview6);


        Map<String, String> map = new HashMap<>();
        map.put("异常", "#FF0000");

        hFlow3.setProgress(3, 4, null, null);

        hFlow4.setProgress(5, 5, getResources().getStringArray(R.array.hflow), null);
        hFlow4.setKeyColor(map);

        hFlow5.setProgress(4, 5, getResources().getStringArray(R.array.htime5), null);

        hFlow6.setProgress(5, 5, getResources().getStringArray(R.array.hflow), getResources().getStringArray(R.array.htime5));
        Map<String, String> map1 = new HashMap<>();
        map1.put("接单", "#009999");
        map1.put("取件", "#A65100");
        map1.put("配送", "#620CAC");
        map1.put("完成", "#00733E");
        hFlow6.setKeyColor(map1);
    }
}
