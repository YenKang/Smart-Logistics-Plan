package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Login extends AppCompatActivity {

    private EditText etUsername, etUserpass;
    private Button btnLogin, btnRegister, btnHome;
    private String username, userpass;

    // private TextView tVPhone, tVGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.user_name);
        etUserpass = findViewById(R.id.user_pass);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        btnHome = findViewById(R.id.btn_home);

        // 測試日期格式使用
        Date a =new Date();
        System.out.println(a);

        // 使用 sharedpreferences 判斷使用者是否已在此裝置登入過，若 user_id 不存在則預設 -1
        SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        int login = sharedPreferences.getInt("user_id",-1);
        // 若已登入過，則直接進入會員頁面
        if (login != -1){
            Intent it = new Intent();
            it.setClass(this, AccountActivity.class);
            this.startActivity(it);
            finish();
        }
        processControllers();
    }

    // 負責監聽本頁面所有按鈕事件的函式
    private void processControllers() {
        // 使用者點擊登入鍵的事件
        Button.OnClickListener loginListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 將使用者輸入的帳密放入變數
                username = etUsername.getText().toString();
                userpass = etUserpass.getText().toString();
                // 於 BackGroundTask 中告知要回傳結果類型的參數
                String method = "login";
                // 檢查使用者是否輸入帳密
                if(username.equals("")){
                    Toast.makeText(Login.this, "請輸入帳號", Toast.LENGTH_LONG).show();
                }
                else if(userpass.equals("")){
                    Toast.makeText(Login.this, "請輸入密碼", Toast.LENGTH_LONG).show();
                }
                // 若皆有輸入則進入 backGroundTask 進行登入處理並結束本頁面
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("FCM_token",0);
                    String FCM_token = sharedPreferences.getString("token","");
                    BackGroundTask backgroundTask = new BackGroundTask(Login.this);
                    backgroundTask.execute(method, username, userpass, FCM_token);
                    finish();
                }
            }
        };
        btnLogin.setOnClickListener(loginListener);

        // 註冊
        Button.OnClickListener btnRegisterListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Login.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        };
        btnRegister.setOnClickListener(btnRegisterListener);

        // 回首頁
        Button.OnClickListener btnReturnListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        };
        btnHome.setOnClickListener(btnReturnListener);
    }
}
