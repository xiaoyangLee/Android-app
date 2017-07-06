package com.example.xiaoyang.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
//import android.view.KeyEvent;
//import android.view.MotionEvent;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        Button button1= (Button)findViewById(R.id.button2);
        final TextView textView = (TextView)findViewById(R.id.textView);
        button1.setOnClickListener(new MyButton());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Log.i();
               textView.setText("我不听我不听！");
            }
        });

    }
    //响应按键按下事件
//    public boolean onKeyDown(int keyCode, KeyEvent event){
//        Toast.makeText(this,"按键按下",Toast.LENGTH_SHORT).show();
//        return super.onKeyDown(keyCode,event);
//    }
    //响应按键松开事件
//    public boolean onKeyUp(int keyCode,KeyEvent event){
//        Toast.makeText(this,"按键弹起",Toast.LENGTH_SHORT).show();
//        return super.onKeyUp(keyCode,event);
//    }
    //响应屏幕触摸事件
//    public boolean onTouchEvent(MotionEvent event){
//        float x = event.getX(); //获取触摸点的X坐标
//        float y = event.getY(); //获取触摸点的Y坐标
//        Toast.makeText(this, "点击的坐标为("+x+":"+y+")", Toast.LENGTH_SHORT).show();
//        return super.onTouchEvent(event);
//    }
    private class MyButton implements View.OnClickListener{
        TextView textView = (TextView)findViewById(R.id.textView);
        @Override
        public void onClick(View v) {
            textView.setText("hello world!");
        }
    }
}

