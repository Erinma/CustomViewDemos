package com.example.a11mcustomviewdemo01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mamiaomiao on 2018/1/25.
 * 标题导航栏
 */

public class TitleView extends RelativeLayout {
    private TextView back, title, ok;
    private Context context;

    //一个参数的构造方法，如果没有使用布局文件才执行。
    public TitleView(Context context) {
        super(context);
    }

    //继承RelativeLayout的自定义view使用两个参数的构造方法。
    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        back = (TextView) view.findViewById(R.id.title_back);
        title = (TextView) view.findViewById(R.id.title_text);

    }

    public void setBackLisner(OnClickListener lisner) {
        //假如需要不同的点击事件
        // back.setOnClickListener(lisner);
        //点击响应相同
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "back page", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //更改标题
    public void setTitle(String titles) {
        title.setText(titles);
    }
}
