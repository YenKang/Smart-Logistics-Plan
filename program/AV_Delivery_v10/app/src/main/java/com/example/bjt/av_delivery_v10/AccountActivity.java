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

    private Button btn1;
    private TextView tVName, tVGender, tVPhone, tVRegisterTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        tVName = findViewById(R.id.tVName);
        tVGender = findViewById(R.id.tVGender);
        tVPhone = findViewById(R.id.tVPhone);
        tVRegisterTime = findViewById(R.id.tVRegisterTime);

        SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        ///接收從Background來的資料
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("username");
        String gender = bundle.getString("gender");
        String phone_number = bundle.getString("phone_number");
        String registerTime = bundle.getString("register_time");
        tVName.setText(name);
        if (gender.equals("0")){
            tVGender.setText("性別：女");
        }
        else if (gender.equals("1")){
            tVGender.setText("性別：男" );
        }
        tVPhone.setText(phone_number);
        tVRegisterTime.setText(registerTime);

        //processControllers();

    }

    /*private void processControllers() {
         //btn1 = findViewById(R.id.button1);
         //Button.OnClickListener btn1Listener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Toast.makeText(AccountActivity.this ,"123",Toast.LENGTH_LONG).show();
               // txt1.setText("123451111");
               // BackGroundTask backgroundTask = new BackGroundTask(AccountActivity.this);
                //backgroundTask.execute(method, name, user_name, user_pass);

            }
         };
         //btn1.setOnClickListener(btn1Listener);
    }*/
}