package com.android.xiaoyang.userinfomanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpButton;
    private EditText birthdayText;
    private EditText accountText;
    private EditText passwordText;
    private EditText phoneNumber;
    private RadioButton manRadio;
    private RadioButton womanRadio;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        accountText=(EditText)findViewById(R.id.account_signUp);
        passwordText=(EditText)findViewById(R.id.passwd_signUp);
        birthdayText=(EditText)findViewById(R.id.birthday_signUp);
        phoneNumber=(EditText)findViewById(R.id.phoneNumber_signUp);
        signUpButton=(Button)findViewById(R.id.sign_up_button);
        manRadio=(RadioButton)findViewById(R.id.radioMale);
        womanRadio=(RadioButton)findViewById(R.id.radioFemale);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }
        });
    }

    private void passDate(){
        Intent intent = new Intent(this,ShowInfoActivity.class);
        //将数据存入intent对象
        intent.putExtra("account",accountText.getText().toString().trim());
        intent.putExtra("password",passwordText.getText().toString().trim());
        intent.putExtra("phoneNumber",phoneNumber.getText().toString().trim());
        intent.putExtra("birthday",birthdayText.getText().toString().trim());
        String str = "";
        if (manRadio.isChecked()){
            str = "男";
        }
        else {
            str="女";
        }
        intent.putExtra("sex",str);
        startActivity(intent);
    }

    /**
     * datePickerDialog()用于设置用户的出生日期
     *以一个日历框的形式显示。
     */
    private void datePickerDialog() {
        new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                String date = String.format("%d-%d-%d", year, monthOfYear+1, dayOfMonth);
                birthdayText.setText(date);
            }
        }, year, month, day).show();
    }

    //获取当前系统时间
    private void date() {
       Calendar c = Calendar.getInstance();
        //年
        year = c.get(Calendar.YEAR);
        //月
        month = c.get(Calendar.MONTH);
        //日
        day = c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 生日输入框点击事件处理
     * @param v
     */
    protected void dateClick(View v){
        date();
        datePickerDialog();
    }
}
