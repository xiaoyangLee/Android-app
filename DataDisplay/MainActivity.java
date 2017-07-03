package com.android.xiaoyang.embbedexer4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText user_name;
    EditText user_pass;
    // CheckBox checkBox = (CheckBox)findViewById(R.id.checkbox);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name = (EditText)findViewById(R.id.user_name);
        user_pass = (EditText)findViewById(R.id.user_pass);
        readAccount();

    }
    public void login(View v){
        String name = user_name.getText().toString();
        String pass = user_pass.getText().toString();
        CheckBox checkBox =(CheckBox)findViewById(R.id.checkbox);
        if (checkBox.isChecked()) {
            File file = new File("data/data/cn.itcast.demo.demo3/ifno.txt");
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write((name + "##" + pass).getBytes());
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent intent = new Intent();
            intent.setClass(this,SecondActivity.class);
            startActivity(intent);
            Toast.makeText(this,"进入第二个Activity",Toast.LENGTH_SHORT).show();
        }
        else {
            //不保存账户密码直接进入第二个Activity
            Intent intent = new Intent();
            intent.setClass(this, SecondActivity.class);
            startActivity(intent);
            Toast.makeText(this,"不保存账户密码",Toast.LENGTH_SHORT).show();
        }
    }
    protected void readAccount(){
        File file = new File("data/data/cn.itcast.demo.demo3/ifno.txt");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String text = bufferedReader.readLine();
                String[] text1 = text.split("##");
                user_name.setText(text1[0]);
                user_pass.setText(text1[1]);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}