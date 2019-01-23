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
    private Button btnLogin, btnRegister;
    private String username, userpass;

    private TextView tVPhone, tVGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.user_name);
        etUserpass = findViewById(R.id.user_pass);
        btnLogin = findViewById(R.id.btn_login);

        Date a =new Date();
        System.out.println(a);

        SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        /*SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("qqq","FUCKING GO");
        editor.commit();*/
        int login = sharedPreferences.getInt("user_id",-1);
        // Toast.makeText(this, Integer.toString(login), Toast.LENGTH_LONG).show();
        // 若已登入過，則直接進入會員頁面
        if (login != -1){
            Intent it = new Intent();
            it.setClass(this, AccountActivity.class);
            this.startActivity(it);
            finish();
        }
        processControllers();
    }

    private void processControllers() {
        //btn1 = findViewById(R.id.button1);
        Button.OnClickListener loginListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                username = etUsername.getText().toString();
                userpass = etUserpass.getText().toString();
                String method = "login";
                SharedPreferences sharedPreferences = getSharedPreferences("login_info",0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                if(username.equals("")){
                    Toast.makeText(Login.this, "請輸入帳號", Toast.LENGTH_LONG).show();
                }
                else if(userpass.equals("")){
                    Toast.makeText(Login.this, "請輸入密碼", Toast.LENGTH_LONG).show();
                }
                else {
                    BackGroundTask backgroundTask = new BackGroundTask(Login.this);
                    backgroundTask.execute(method, username, userpass);
                    finish();
                }
            }
        };
        btnLogin.setOnClickListener(loginListener);
    }
}
