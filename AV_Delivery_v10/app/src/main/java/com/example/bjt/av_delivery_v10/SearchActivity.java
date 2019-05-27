package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private String input;
    private TextInputEditText inputNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        inputNo = findViewById(R.id.inputNo);
        Button search_btn = findViewById(R.id.search_btn);

        // 依貨號查詢
        View.OnClickListener searchListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = inputNo.getText().toString();
                new OrderQueryByNo(SearchActivity.this).execute(input);
            }
        };
        search_btn.setOnClickListener(searchListener2);


    }
}
