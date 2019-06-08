package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

    private Button btn_logout, btn_return;
    private TextView tVName, tVGender, tVPhone, tVRegisterTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        tVName = findViewById(R.id.tVName);
        tVGender = findViewById(R.id.tVGender);
        tVPhone = findViewById(R.id.tVPhone);
        tVRegisterTime = findViewById(R.id.tVRegisterTime);

        // 準備於頁面顯示會員資料
        String name, pass, gender, phone_number, registerTime;
        // 使用 sharedpreferences 判斷使用者是否已在此裝置登入過，若 user_id 不存在則預設 -99
        SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        int user_id = sharedPreferences.getInt("user_id",-99);

        // 若尚未登入過，則本次為第一次登入並進入此頁面，需記錄使用者資訊
        if (user_id == -99) {
            ///接收從 BackGroundTask 來的 bundle 提取其中資料並存入 user_info
            Bundle bundle = getIntent().getExtras();
            user_id = bundle.getInt("user_id");
            name = bundle.getString("username");
            pass = bundle.getString("password");
            gender = bundle.getString("gender");
            phone_number = bundle.getString("phone_number");
            registerTime = bundle.getString("register_time");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("user_id",user_id);
            editor.putString("username",name);
            editor.putString("password",pass);
            editor.putString("gender",gender);
            editor.putString("phone_number",phone_number);
            editor.putString("register_time",registerTime);
            // 儲存用來進行推播通知的 key
            editor.putString("device_key", bundle.getString("device_key"));

            //editor.putStringSet()
            editor.commit();
        }
        // 若已登入，則直接從記憶體取得資料
        else {
            name = sharedPreferences.getString("username","-1");
            gender = sharedPreferences.getString("gender","-1");
            phone_number = sharedPreferences.getString("phone_number","-1");
            registerTime = sharedPreferences.getString("register_time", "-1");
        }
        // 顯示會員姓名
        tVName.setText("您好，" + name);
        // 以 0 1 判別性別
        if (gender.equals("0")){
            tVGender.setText("性別：女");
        }
        else if (gender.equals("1")){
            tVGender.setText("性別：男" );
        }
        // 顯示其他會員資訊
        tVPhone.setText("手機號碼："+phone_number);
        tVRegisterTime.setText("註冊日期："+registerTime);
        // 負責監聽按鈕事件的函式
        processControllers();
    }
    // 負責監聽本頁面所有按鈕事件的函式
    private void processControllers() {
         // 使用者登出
         btn_logout = findViewById(R.id.btn_logout);
         Button.OnClickListener btnLogoutListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
                sharedPreferences.edit().clear().commit();
                finish();
            }
         };
         btn_logout.setOnClickListener(btnLogoutListener);

         // 使用者回首頁
         btn_return = findViewById(R.id.btn_return);
         Button.OnClickListener btnReturnListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
         };
         btn_return.setOnClickListener(btnReturnListener);
    }
}