package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btnHome, btnSubmit;
    private EditText etusername, etpassword, etphone, etaddress;
    // private RadioButton rb1, rb2;
    private RadioGroup rg;
    private int gender = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnSubmit = findViewById(R.id.btn_submit_register);
        btnHome = findViewById(R.id.btn_home_register);
        etusername = findViewById(R.id.user_name);
        etpassword = findViewById(R.id.user_pass);
        etphone = findViewById(R.id.user_phone);
        etaddress = findViewById(R.id.user_address);


        // rb1 = findViewById(R.id.RadioButton1);
        // rb2 = findViewById(R.id.RadioButton2);
        rg = findViewById(R.id.RadioGroup);
        rg.check(R.id.RadioButton1);
        rg.setOnCheckedChangeListener(radGrpRegionOnCheckedChange);




        processControllers();
    }

    private RadioGroup.OnCheckedChangeListener radGrpRegionOnCheckedChange =
            new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    // TODO Auto-generated method stub
                    SharedPreferences sharedPreferences = getSharedPreferences("FCM_token",0);
                    String token = sharedPreferences.getString("token","-1");
                    switch (checkedId)
                    {
                        case R.id.RadioButton1: //case mRadioButton0.getId():

                            Toast.makeText(RegisterActivity.this, "男", Toast.LENGTH_SHORT).show();
                            Toast.makeText(RegisterActivity.this, token, Toast.LENGTH_SHORT).show();
                            gender = 0;
                            break;

                        case R.id.RadioButton2: //case mRadioButton1.getId():
                            Toast.makeText(RegisterActivity.this, "女", Toast.LENGTH_SHORT).show();
                            gender = 1;
                            break;
                    }
                }
            };

    // 負責監聽本頁面所有按鈕事件的函式
    private void processControllers() {
        // 回首頁
        Button.OnClickListener btnHomeListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        };
        btnHome.setOnClickListener(btnHomeListener);

        // 提交註冊
        Button.OnClickListener btnRegisterSubmitListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(RegisterActivity.this, etusername.getText(), Toast.LENGTH_SHORT).show();
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();
                String phone = etphone.getText().toString();
                String address = etaddress.getText().toString();
                if ( !username.equals("") && !password.equals("") && !phone.equals("") && !address.equals("")) {
                    //Toast.makeText(RegisterActivity.this, "男", Toast.LENGTH_SHORT).show();
                    // 於 BackGroundTask 中告知要回傳結果類型的參數
                    String method = "register";
                    BackGroundTask backgroundTask = new BackGroundTask(RegisterActivity.this);
                    backgroundTask.execute(method, username, password, Integer.toString(gender), phone, address);
                    //finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "請填寫全部資訊！", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnSubmit.setOnClickListener(btnRegisterSubmitListener);
    }
}
