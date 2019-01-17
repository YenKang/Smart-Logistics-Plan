package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        account = findViewById(R.id.account_button);
        processControllers();


    }

    private void processControllers() {
        View.OnClickListener itemListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"WW",Toast.LENGTH_LONG).show();
                Intent i = new Intent(view.getContext(), Login.class);
                startActivity(i);
            }
        };
        // 註冊選單項目點擊監聽物件
        account.setOnClickListener(itemListener);
    }
}
