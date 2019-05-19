package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyOrderActivity extends AppCompatActivity {
    // private TabLayout mTabs;
    // private ViewPager mViewPager;

    // 資料庫取得訂單資料並放入JsonArray
    private JSONArray orderArray;
    // 宣告一個 ListView 以顯示使用者訂單
    private ListView order_list;
    // ListView 使用的自定義 Adapter，使用連線資料庫取得之資料
    private ItemAdapter itemAdapter;
    // private ItemAdapter order_adapter;
    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        order_list = findViewById(R.id.order_list);
        // 建立使用者點擊事件
        processControllers();
        // 將從主頁面連線資料庫取得的訂單資料存入變數 orderArray 以便接下來放入 adapter 使用
        Intent intent = getIntent();
        SerializableJSONArray jsonReceiver = (SerializableJSONArray)intent.getSerializableExtra("orderReceived");
        orderArray = jsonReceiver.getJSONArray();
        // 將 orderArray 中的資料取出，並放到 items 準備以 adapter 形式存起來
        items = new ArrayList<Item>();
        for (int i = 0; i < orderArray.length(); i++){
            try {
                String order_No = orderArray.getJSONObject(i).getString("order_number");
                String sender_name = orderArray.getJSONObject(i).getString("sender_name");
                String receiver_name = orderArray.getJSONObject(i).getString("receiver_name");
                String cargo_content = orderArray.getJSONObject(i).getString("cargo_content");
                int price = orderArray.getJSONObject(i).getInt("price");
                String container_No = orderArray.getJSONObject(i).getString("container_id");
                // 上下貨時間比較麻煩，需要一些轉換處理
                String in_time_DB = orderArray.getJSONObject(i).getString("in_time");
                String out_time_DB = orderArray.getJSONObject(i).getString("out_time");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date parsedDate = dateFormat.parse(in_time_DB);
                Date parsedDate2 = dateFormat.parse(out_time_DB);
                Timestamp in_time = new java.sql.Timestamp(parsedDate.getTime());
                Timestamp out_time = new java.sql.Timestamp(parsedDate2.getTime());
                /////////
                int status = orderArray.getJSONObject(i).getInt("status");
                String truck_No = orderArray.getJSONObject(i).getString("truck_id");
                double[] lnglat = new double[4];
                double slng = orderArray.getJSONObject(i).getDouble("sender_lng");
                double slat = orderArray.getJSONObject(i).getDouble("sender_lat");
                double rlng = orderArray.getJSONObject(i).getDouble("receiver_lng");
                double rlat = orderArray.getJSONObject(i).getDouble("receiver_lat");
                lnglat[0] = slng;
                lnglat[1] = slat;
                lnglat[2] = rlng;
                lnglat[3] = rlat;
                String order_time_DB = orderArray.getJSONObject(i).getString("order_time");
                Date parsedDate3 = dateFormat.parse(order_time_DB);
                Timestamp order_time = new java.sql.Timestamp(parsedDate3.getTime());
                // 初始化 item 並加入 items
                items.add(new Item(i, order_No, sender_name, receiver_name, cargo_content, price,
                        container_No, in_time, out_time, status, truck_No, lnglat, order_time));
                // Toast.makeText(this,in_time.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        // 將 items 放入 adapter，並顯示於本畫面
        itemAdapter = new ItemAdapter(this,R.layout.single_item, items);
        order_list.setAdapter(itemAdapter);
        /*try {
            Toast.makeText(MyOrderActivity.this, orderArray.getJSONObject(0).toString(),Toast.LENGTH_SHORT).show();
            Toast.makeText(MyOrderActivity.this, orderArray.getJSONObject(1).toString(),Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        // TAB 功能，以後再說
        /*mTabs = (android.support.design.widget.TabLayout) findViewById(R.id.pager_tabs);
        mTabs.addTab(mTabs.newTab().setText("我寄出的"));
        mTabs.addTab(mTabs.newTab().setText("寄給我的"));

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        //mViewPager.setAdapter(new MyPagerAdapter());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));*/


    }

    private void processControllers() {

        // 建立選單項目點擊監聽物件
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener(){
            // 第一個參數是使用者操作的ListView物件
            // 第二個參數是使用者選擇的項目
            // 第三個參數是使用者選擇的項目編號，第一個是0
            // 第四個參數在這裡沒有用途
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                // 讀取被點選的記事物件
                // 測試寫法，測試成功
                // Item item = items.get(position);
                Item item = itemAdapter.getItem(position);

                Intent intent = new Intent(MyOrderActivity.this,ItemActivity.class);
                // 設定記事編號與標題
                intent.putExtra("position", position);
                intent.putExtra("item", item);
                // 呼叫「startActivityForResult」，第二個參數「1」表示執行修改
                startActivity(intent);
            }
        };
        // 註冊選單項目點擊監聽物件
        order_list.setOnItemClickListener(itemListener);

    }

}


