package com.example.bjt.av_delivery_v10;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        tVPhone = findViewById(R.id.tVPhone);
        tVGender = findViewById(R.id.tVGender);

        SharedPreferences sharedPreferences = getSharedPreferences("login_info",0);
        Bundle bundle = new Bundle();
        String test = bundle.getString("qqq","0");
        Toast.makeText(this,test,Toast.LENGTH_LONG).show();

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

                if(username.equals("")){
                    Toast.makeText(Login.this, "請輸入帳號", Toast.LENGTH_LONG).show();
                }
                else if(userpass.equals("")){
                    Toast.makeText(Login.this, "請輸入密碼", Toast.LENGTH_LONG).show();
                }
                else {
                    BackGroundTask backgroundTask = new BackGroundTask(Login.this);
                    backgroundTask.execute(method, username, userpass);
                }
            }
        };
        btnLogin.setOnClickListener(loginListener);
    }
}
