package com.xyz.stepview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/**
 * Created by paike on 2017/2/10.
 * xyz@163.com
 */

public class Demo extends View implements Animator.AnimatorListener {

    private Paint proPaint;
    private RectF rectF;
    private float startAngle = 180;
    private float sweepAngle = 0;
    private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();

    public Demo(Context context) {
        this(context, null);
    }

    public Demo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Demo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        proPaint = new Paint();
        proPaint.setAntiAlias(true);
        proPaint.setStyle(Paint.Style.FILL);
        proPaint.setColor(Color.parseColor("#029dd5"));
        proPaint.setStrokeWidth(30);
        rectF = new RectF(0, 0,
                300, 300);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(rectF, startAngle, sweepAngle, false, proPaint);
    }

    public void changeFloat() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 360);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(mInterpolator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                sweepAngle = (float) animation.getAnimatedValue();
                startAngle = 180 - (((float) animation.getAnimatedValue()) / 2);
                invalidate();
            }
        });
        valueAnimator.start();
    }

    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {

    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
