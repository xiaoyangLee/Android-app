package com.android.xiaoyang.userinfomanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class ShowInfoActivity extends AppCompatActivity {

    private TextView accountText;
    private TextView passwordText;
    private TextView phoneNumberText;
    private TextView sexText;
    private TextView birthdayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        //获取传递来的intent对象
        Intent intent = getIntent();
        //取出key对应的值
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");
        String phoneNumber = intent.getStringExtra("phoneNumber");
        String birthday = intent.getStringExtra("birthday");
        String sex = intent.getStringExtra("sex");

        accountText = (TextView) findViewById(R.id.account_show);
        passwordText = (TextView) findViewById(R.id.passwd_show);
        phoneNumberText = (TextView) findViewById(R.id.phoneNumber_show);
        sexText = (TextView) findViewById(R.id.sex_show);
        birthdayText = (TextView) findViewById(R.id.birthday_show);

        accountText.setText("账户名:  " + account);
        passwordText.setText("密    码:  " + password);
        phoneNumberText.setText("电    话:  " + phoneNumber);
        birthdayText.setText("生    日:  " + birthday);
        sexText.setText("性    别:  " + sex);

        //定义按钮以及时间
        Button btnKeepFile = (Button) findViewById(R.id.btn_keepfile);
        Button btnKeepDatabase = (Button) findViewById(R.id.btn_keepDatabase);

        btnKeepFile.setOnClickListener(new MyButton());
        btnKeepDatabase.setOnClickListener(new MyButton());
    }

    /**
     * 设置Button的监听事件实现
     */
    private class MyButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_keepfile:
                    keepFile();
                    break;
                case R.id.btn_keepDatabase:
                    Toast.makeText(ShowInfoActivity.this, "此功能还没开发呢", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    /**
     * 保存文件到内部存储上
     */
    private void keepFile() {
        String accountSave = accountText.getText().toString().trim();
        String passwdSave = passwordText.getText().toString().trim();
        String phonenumberSave = phoneNumberText.getText().toString().trim();
        String sexSave = sexText.getText().toString().trim();
        String birthdaySave = birthdayText.getText().toString().trim();

        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openFileOutput("data.txt", Context.MODE_APPEND);
            fileOutputStream.write(accountSave.getBytes());
            fileOutputStream.write(passwdSave.getBytes());
            fileOutputStream.write(phonenumberSave.getBytes());
            fileOutputStream.write(sexSave.getBytes());
            fileOutputStream.write(birthdaySave.getBytes());
            fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Toast.makeText(ShowInfoActivity.this,"数据保存成功",Toast.LENGTH_SHORT).show();
        return;
    }

}
