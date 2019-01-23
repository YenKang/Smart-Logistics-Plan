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

    private Button btn_logout;
    private TextView tVName, tVGender, tVPhone, tVRegisterTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        tVName = findViewById(R.id.tVName);
        tVGender = findViewById(R.id.tVGender);
        tVPhone = findViewById(R.id.tVPhone);
        tVRegisterTime = findViewById(R.id.tVRegisterTime);

        String name, pass, gender, phone_number, registerTime;
        SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        int user_id = sharedPreferences.getInt("user_id",-99);

        // 若尚未登入過，則本次為第一次進入此頁面，需記錄使用者資訊
        if (user_id == -99) {
            ///接收從Background來的資料
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
            editor.commit();
        }
        // 若已登入，則直接從記憶體取得資料
        else {
            name = sharedPreferences.getString("username","-1");
            gender = sharedPreferences.getString("gender","-1");
            phone_number = sharedPreferences.getString("phone_number","-1");
            registerTime = sharedPreferences.getString("register_time", "-1");
        }
        ///接收從Background來的資料
        /*Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("username");
        String gender = bundle.getString("gender");
        String phone_number = bundle.getString("phone_number");
        String registerTime = bundle.getString("register_time");*/
        tVName.setText("您好，" + name);
        if (gender.equals("0")){
            tVGender.setText("性別：女");
        }
        else if (gender.equals("1")){
            tVGender.setText("性別：男" );
        }
        tVPhone.setText(phone_number);
        tVRegisterTime.setText(registerTime);

        processControllers();

    }

    private void processControllers() {
         btn_logout = findViewById(R.id.btn_logout);
         Button.OnClickListener btnlogoutListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Toast.makeText(AccountActivity.this ,"123",Toast.LENGTH_LONG).show();
                // txt1.setText("123451111");
                // BackGroundTask backgroundTask = new BackGroundTask(AccountActivity.this);
                //backgroundTask.execute(method, name, user_name, user_pass);
                SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
                sharedPreferences.edit().clear().commit();
                finish();
            }
         };
         btn_logout.setOnClickListener(btnlogoutListener);
    }
}