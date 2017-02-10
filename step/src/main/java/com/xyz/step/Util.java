package com.xyz.step;

import android.content.Context;

/**
 * Created by paike on 2017/2/10.
 * xyz@163.com
 */

class Util {
    /**
     * 把密度转换为像素
     */
    static int dip2px(Context context, float px) {
        final float scale = getScreenDensity(context);
        return (int) (px * scale + 0.5);
    }
    /**
     * 得到设备的密度
     */
    private static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

}
