package com.android.xiaoyang.embbedexer4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void click2(View v){

        EditText editText = (EditText)findViewById(R.id.edit3);
        TextView textView = (TextView)findViewById(R.id.text4);
        String account = editText.getText().toString();

        textView.setText("你确定要给"+account+"打电话吗");

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + account));
        startActivity(intent);

    }
}
