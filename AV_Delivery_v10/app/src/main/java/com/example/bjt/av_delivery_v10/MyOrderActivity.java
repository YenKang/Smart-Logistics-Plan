package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
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
    private android.support.design.widget.TabLayout mTabs;
    private ViewPager mViewPager;

    // 資料庫取得訂單資料並放入JsonArray
    private JSONArray orderArray;
    // 宣告兩個 ListView 分別顯示使用者的兩種訂單 (寄出及收取)
    private ListView order_list_1, order_list_2;
    // ListView 使用的自定義 Adapter，使用連線資料庫取得之資料
    private ItemAdapter itemAdapter1, itemAdapter2;

    // 宣告三個 items 將收到的資料作分類後個別存入
    private List<Item> items, items_send, items_receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        String username = sharedPreferences.getString("username","-1");
        Toast.makeText(this,username,Toast.LENGTH_SHORT).show();

        // 將從主頁面連線資料庫取得的訂單資料存入變數 orderArray 以便接下來放入 adapter 使用
        Intent intent = getIntent();
        SerializableJSONArray jsonReceiver = (SerializableJSONArray)intent.getSerializableExtra("orderReceived");
        orderArray = jsonReceiver.getJSONArray();
        // 將 orderArray 中的資料取出，並放到 items 準備以 adapter 形式存起來
        items = new ArrayList<Item>();
        items_send = new ArrayList<Item>();
        items_receive = new ArrayList<Item>();
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
                String status = orderArray.getJSONObject(i).getString("status");
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
                int sender_time = orderArray.getJSONObject(i).getInt("sender_time");
                int receiver_time = orderArray.getJSONObject(i).getInt("receiver_time");

                if (sender_name.equals(username)){
                    items_send.add(new Item(i, order_No, sender_name, receiver_name, cargo_content, price,
                            container_No, in_time, out_time, status, truck_No, lnglat, order_time, sender_time, receiver_time));
                }
                else if (receiver_name.equals(username)){
                    items_receive.add(new Item(i, order_No, sender_name, receiver_name, cargo_content, price,
                            container_No, in_time, out_time, status, truck_No, lnglat, order_time, sender_time, receiver_time));
                }

                // 初始化 item 並加入 items
                items.add(new Item(i, order_No, sender_name, receiver_name, cargo_content, price,
                        container_No, in_time, out_time, status, truck_No, lnglat, order_time, sender_time, receiver_time));
                // Toast.makeText(this,in_time.toString(), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // 定义一个视图集合（用来装左右滑动的页面视图）
        final List<View> viewList = new ArrayList<View>();

        // 定义两个视图，两个视图都加载同一个布局文件 order_list
        View view1 = getLayoutInflater().inflate(R.layout.order_list, null);
        View view2 = getLayoutInflater().inflate(R.layout.order_list, null);

        // 将两个视图添加到视图集合 viewList 中
        viewList.add(view1);
        viewList.add(view2);

        mTabs = findViewById(R.id.pager_tabs);
        mTabs.addTab(mTabs.newTab().setText("我寄出的"));
        mTabs.addTab(mTabs.newTab().setText("寄給我的"));

        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //这个方法返回一个对象，该对象表明PagerAapter选择哪个对象放在当前的ViewPager中。这里我们返回当前的页面
                mViewPager.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //这个方法从viewPager中移动当前的view。（划过的时候）
                mViewPager.removeView(viewList.get(position));
            }
        });
        // 將 viewpager 與 tab 作連動
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));
        mTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        order_list_1 = view1.findViewById(R.id.order_list);
        order_list_2 = view2.findViewById(R.id.order_list);

        itemAdapter1 = new ItemAdapter(this, R.layout.single_item, items_send);
        itemAdapter2 = new ItemAdapter(this, R.layout.single_item, items_receive);
        order_list_1.setAdapter(itemAdapter1);
        order_list_2.setAdapter(itemAdapter2);


        // order_list = findViewById(R.id.order_list);
        // 建立使用者點擊事件
         processControllers();

        // 將 items 放入 adapter，並顯示於本畫面
        //itemAdapter = new ItemAdapter(this,R.layout.single_item, items);
        //order_list.setAdapter(itemAdapter);

    }

    private void processControllers() {

        // 我寄出的
        AdapterView.OnItemClickListener item1Listener = new AdapterView.OnItemClickListener(){
            // 第一個參數是使用者操作的ListView物件
            // 第二個參數是使用者選擇的項目
            // 第三個參數是使用者選擇的項目編號，第一個是0
            // 第四個參數在這裡沒有用途
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                // 讀取被點選的物件
                Item item = itemAdapter1.getItem(position);
                Intent intent = new Intent(MyOrderActivity.this,ItemActivity.class);
                // 設定是否為收件者以及該訂單資訊
                intent.putExtra("receiver", 0);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        };
        // 註冊選單項目點擊監聽物件
        order_list_1.setOnItemClickListener(item1Listener);

        // 寄給我的
        AdapterView.OnItemClickListener item2Listener = new AdapterView.OnItemClickListener(){
            // 第一個參數是使用者操作的ListView物件
            // 第二個參數是使用者選擇的項目
            // 第三個參數是使用者選擇的項目編號，第一個是0
            // 第四個參數在這裡沒有用途
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                // 讀取被點選的物件
                Item item = itemAdapter2.getItem(position);

                Intent intent = new Intent(MyOrderActivity.this,ItemActivity.class);
                // 設定是否為收件者以及該訂單資訊
                intent.putExtra("receiver", 1);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        };
        // 註冊選單項目點擊監聽物件
        order_list_2.setOnItemClickListener(item2Listener);

    }

    /*
    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Item " + (position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getLayoutInflater().inflate(R.layout.order_list, container, false);
            container.addView(view);

            order_list = findViewById(R.id.order_list);
            // 將 items 放入 adapter，並顯示於本畫面
            itemAdapter = new ItemAdapter(MyOrderActivity.this, R.layout.single_item, items);
            order_list.setAdapter(itemAdapter);
            if (position == 1) {
                order_list = findViewById(R.id.order_list);
                // 將 items 放入 adapter，並顯示於本畫面
                itemAdapter = new ItemAdapter(MyOrderActivity.this, R.layout.single_item, items);
                order_list.setAdapter(itemAdapter);
            }

            return view;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
    */

}


