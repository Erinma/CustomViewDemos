package com.example.a11mcustomviewdemo01;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TitleView titleView;
private String[] data={"小摩托","小汽车定的","叨叨的的二","定的","叨叨的的二二二多多多","小摩托","小汽车定的","叨叨的的二","定的","dddd"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleView=(TitleView)findViewById(R.id.mytitle);
        titleView.setTitle("第一个页面");
MutiTextView my=(MutiTextView)findViewById(R.id.mymulti);
for(int i=0;i<10;i++){
    TextView textView=new TextView(MainActivity.this);
    textView.setText(data[i]);
    textView.setTextColor(Color.WHITE);
    textView.setBackgroundColor(Color.RED);
    my.addView(textView);
}
my.setBackgroundColor(Color.GRAY);

    }
}
