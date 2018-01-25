package com.example.a11mcustomviewdemo01;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mamiaomiao on 2018/1/25.
 * 购物车加减器
 */

public class PlusView extends LinearLayout implements View.OnClickListener {
    private TextView plus, dec;
    private EditText editText;
    private Context context;

    public PlusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        LayoutInflater.from(context).inflate(R.layout.plus_layout, this);
        plus = (TextView) findViewById(R.id.plus);
        dec = (TextView) findViewById(R.id.dec);
        editText = (EditText) findViewById(R.id.input);
        //+-按钮设置点击事件
        plus.setOnClickListener(this);
        dec.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int currentNum = getNum();

        switch (v.getId()) {

            case R.id.plus:
                //点击+
                editText.setText((currentNum + 1) + "");
                break;
            case R.id.dec:
//点击-
                if (currentNum > 1) {
                    editText.setText((currentNum - 1) + "");
                } else {
                    Toast.makeText(context,"当前数字为1，不能减少",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //获取当前输入框的数字
    public int getNum() {
        String text = editText.getText().toString();
        if (text == null || text.equals("")) {
            return 1;
        }
        int num = Integer.parseInt(text);
        if (num > 1) {
            return num;
        }
        return 1;
    }
}
