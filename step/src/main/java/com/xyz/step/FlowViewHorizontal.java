package com.xyz.step;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Map;

/**
 * Created by paike on 2017/1/9.
 * xyz@163.com
 */

public class FlowViewHorizontal extends View {

    private Paint bgPaint;
    private Paint proPaint;
    private float bgRadius;
    private float proRadius;
    private float startX;
    private float stopX;
    private float bgCenterY;
    private int lineBgWidth;
    private int bgColor;
    private int lineProWidth;
    private int proColor;
    private int textPadding;
    private int timePadding;
    private int circleCount;
    private int textSize;
    private int circlePro;
    private int interval;
    private String[] titles = {"提交", "接单", "取件", "配送", "完成"};
    private String[] times;
    private Map<String, String> map;

    public FlowViewHorizontal(Context context) {
        this(context, null);
    }

    public FlowViewHorizontal(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowViewHorizontal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.flowview_horizontal);
        bgRadius = ta.getDimension(R.styleable.flowview_horizontal_bg_radius, 10);
        proRadius = ta.getDimension(R.styleable.flowview_horizontal_pro_radius, 8);
        lineBgWidth = (int) ta.getDimension(R.styleable.flowview_horizontal_line_bg_width, 3f);
        bgColor = ta.getColor(R.styleable.flowview_horizontal_bg_color, Color.parseColor("#cdcbcc"));
        lineProWidth = (int) ta.getDimension(R.styleable.flowview_horizontal_line_pro_width, 2f);
        proColor = ta.getColor(R.styleable.flowview_horizontal_pro_color, Color.parseColor("#029dd5"));
        textPadding = (int) ta.getDimension(R.styleable.flowview_horizontal_text_padding, 20);
        timePadding = (int) ta.getDimension(R.styleable.flowview_horizontal_time_padding, 30);
        circleCount = ta.getInt(R.styleable.flowview_horizontal_circle_count, 5);
        textSize = (int) ta.getDimension(R.styleable.flowview_horizontal_textsize, 20);
        circlePro = ta.getInt(R.styleable.flowview_horizontal_circle_pro, 1);
        ta.recycle();
        init();
    }

    private void init() {
        bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(bgColor);
        bgPaint.setStrokeWidth(lineBgWidth);
        bgPaint.setTextSize(textSize);
        bgPaint.setTextAlign(Paint.Align.CENTER);

        proPaint = new Paint();
        proPaint.setAntiAlias(true);
        proPaint.setStyle(Paint.Style.FILL);
        proPaint.setColor(proColor);
        proPaint.setStrokeWidth(lineProWidth);
        proPaint.setTextSize(textSize);
        proPaint.setTextAlign(Paint.Align.CENTER);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int bgWidth;
        if (widthMode == MeasureSpec.EXACTLY) {
            bgWidth = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();
        } else
            bgWidth = Util.dip2px(getContext(), 311);

        int bgHeight;
        if (heightMode == MeasureSpec.EXACTLY) {
            bgHeight = MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop() - getPaddingBottom();
        } else
            bgHeight = Util.dip2px(getContext(), 49);
        float left = getPaddingLeft() + bgRadius;
        stopX = bgWidth - bgRadius;
        startX = left;
        bgCenterY = bgHeight / 2;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        interval = (int) ((stopX - startX) / (circleCount - 1));
        drawBg(canvas);
        drawProgress(canvas);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < circleCount; i++) {
            if (i < circlePro) {
                setPaintColor(i);
                if (null != titles)
                    canvas.drawText(titles[i], startX + (i * interval), bgCenterY - textPadding, proPaint);
                if (null != times)
                    canvas.drawText(times[i], startX + (i * interval), bgCenterY + timePadding, proPaint);
            } else {
                if (null != titles)
                    canvas.drawText(titles[i], startX + (i * interval), bgCenterY - textPadding, bgPaint);
            }
        }
    }

    private void setPaintColor(int i) {
        if (titles == null || map == null) return;
        String title = titles[i];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (title.contains(entry.getKey())) {
                String value = entry.getValue();
                proPaint.setColor(Color.parseColor(value));
            } else {
                proPaint.setColor(proColor);
            }
        }
    }

    private void drawProgress(Canvas canvas) {
        int linePro;
        float lastLeft = startX;
        for (int i = 0; i < circlePro; i++) {
            setPaintColor(i);
            if (i == 0 || i == circleCount - 1)
                linePro = interval / 2;
            else
                linePro = interval;
            canvas.drawLine(lastLeft, bgCenterY, lastLeft + linePro, bgCenterY, proPaint);
            lastLeft = lastLeft + linePro;
            canvas.drawCircle(startX + (i * interval), bgCenterY, proRadius, proPaint);
        }
    }

    private void drawBg(Canvas canvas) {
        canvas.drawLine(startX, bgCenterY, stopX, bgCenterY, bgPaint);
        for (int i = 0; i < circleCount; i++) {
            canvas.drawCircle(startX + (i * interval), bgCenterY, bgRadius, bgPaint);
        }
    }


    public void setProgress(int progress, int circleCount, String[] titles, String[] times) {
        circlePro = progress;
        this.circleCount = circleCount;
        this.titles = titles;
        this.times = times;
        invalidate();
    }

    public void setKeyColor(Map<String, String> map) {
        this.map = map;
    }
}
