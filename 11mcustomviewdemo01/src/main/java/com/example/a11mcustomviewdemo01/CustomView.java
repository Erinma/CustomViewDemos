package com.example.a11mcustomviewdemo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mamiaomiao on 2018/1/25.
 * 绘制小球跟随手指滑动
 */

public class CustomView extends View implements View.OnTouchListener {
    private float circlex = 150, circley = 150;

    //继承view时，构造方法最少要写三个
    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //手指摁下
                circlex = event.getX();
                circley = event.getY();
                System.out.println("ewwww" + circlex + "  ," + circley);
                invalidate();//强制重绘

                break;
            case MotionEvent.ACTION_UP:
                //手指抬起

                break;
            case MotionEvent.ACTION_MOVE:
                //手指移动
                circlex = event.getX();
                circley = event.getY();
                System.out.println("ddddd" + circlex + "  ," + circley);
                invalidate();//强制重绘
                break;
        }
        //return改为true；
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //负责绘制
        //实例化画笔
        Paint paint = new Paint();
        //画笔设置红色
        paint.setColor(Color.RED);
        //绘制一个圆心在（150，150），半径为100的圆；
        //canvas.drawCircle(150,150,100,paint);
        //绘制动态圆，实时更新圆心的坐标。
        canvas.drawCircle(circlex, circley, 100, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //负责测量
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //负责布局子控件
    }
}
