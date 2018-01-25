package com.example.a11mcustomviewdemo01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mamiaomiao on 2018/1/25.
 * 模仿流式布局，通过重新布局子view的位置，来实现各种效果。
 */

public class MutiTextView extends ViewGroup {
    public MutiTextView(Context context) {
        super(context);
    }

    public MutiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MutiTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //集成viewgroup必须重写
        int count = getChildCount();//获取子view的个数；
        int totleWidth = l+10;
        int totleheight = t;
        int midheight = 0;
        for (int i = 0; i < count; i++) {
            View item = getChildAt(i);//获取对应位置的子view
            //获取子view的宽与高
            float width = item.getMeasuredWidth();
            float height = item.getMeasuredHeight();
            if (getWidth() - totleWidth > width+20) {//判断应该放在同一行；
                item.layout(totleWidth+20, totleheight, (totleWidth += width+20), (int) (totleheight + height));

                midheight = (int) height;
            } else {//判断放入下一行
                totleWidth = l;//换行置0
                totleheight += midheight;
                item.layout(totleWidth+20, totleheight, (totleWidth += width+20), (int) (totleheight + height));
            }

        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int index = 0; index < getChildCount(); index++) {
            final View child = getChildAt(index);
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        }
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);
    }
}
