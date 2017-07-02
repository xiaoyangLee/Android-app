package com.example.xiaoyang.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //定义百万富翁按钮
        Button button_million = (Button)findViewById(R.id.buttonMillion);
        //定义打开便签按钮
        Button button_keep = (Button)findViewById(R.id.buttonKeep);

        button_million.setOnClickListener(new MyButton());
        button_keep.setOnClickListener(new MyButton());
    }

    @Override
    public void onBackPressed(){
        // 方法 1: goto the default launcher. It's not recommended.
        // Intent i = new Intent(Intent.ACTION_MAIN);
        // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // i.addCategory(Intent.CATEGORY_HOME);
        // startActivity(i);

        // 方法 2: goto the default launcher. It's recommended.
        moveTaskToBack(true);
    }

    private class MyButton implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonMillion:
                    Intent intent = new Intent(MainActivity.this, MillionActivity.class);
                    startActivity(intent);
                    break;
                case R.id.buttonKeep:
                    Intent intent1 = new Intent(MainActivity.this,KeepActivity.class);
                    startActivity(intent1);
                    break;
                default:
                    break;
            }
        }
    }
}
