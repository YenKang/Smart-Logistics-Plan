package com.example.bjt.av_delivery_v10;

import android.app.Dialog;
import android.app.ProgressDialog;
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

    private Dialog dialog;

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
                dialog = ProgressDialog.show(SearchActivity.this,
                        "讀取中", "正在讀取訂單資料...",true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            dialog.dismiss();
                        }
                    }
                }).start();
            }
        };
        search_btn.setOnClickListener(searchListener2);


    }
}
