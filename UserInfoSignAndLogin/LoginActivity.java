package com.android.xiaoyang.userinfomanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.email_sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempLogin();
            }
        });
    }

    protected void attempLogin() {
        userName = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        String account = userName.getText().toString();
        String passwd = password.getText().toString();

        if (account.equals("")) {
            //Toast.makeText(this,"账户名或者密码不得为空",Toast.LENGTH_SHORT).show();
            userName.setError("账户名不得为空");
            return;
        }
        if (passwd.equals("")) {
            password.setError("密码不得为空");
            return;
        }
        if (account.equals("lxy@qq.com") && passwd.equals("123456")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            //userName.setError("账户名或者密码不正确！");
            Toast.makeText(this, "账户名或者密码不正确！", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    protected void signUpClick(View view){
        Intent intent =new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}
