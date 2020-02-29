package com.example.bjt.av_delivery_v10;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Handler;
import android.os.Message;


import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.Socket;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.security.AccessController.getContext;

public class MapTestActivity extends FragmentActivity implements OnMapReadyCallback {

    private List<String> timeFilterList;
    private ArrayAdapter<String> adapterForTimeFilter;
    private Context context;
    private int[] timeSelect = new int[12];


    private Socket clientSocket;
    private String temp;
    private JSONObject jsonR, jsonW;
    private GoogleMap mMap;
    private String originAddress, destAddress;
    private String sender_id, receiver_id, cargo_content;
    private int price, size;
    private int timeArrived;
    private double weight;
    private Double lng1, lat1, lng2, lat2, cameraLng, cameraLat;
    private Double camaraLng2, cameraLat2;
    private Button submit_button, cancel_button;

    private Dialog dialog;
    private Handler handler;

    private String container_id;

    private int isReceiver;
    private Item order_item;
    private Map hashmap = new HashMap();
    // private TextView tvLng1, tvLat1, tvLng2, tvLat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_test);

        Spinner spinnerTime = findViewById(R.id.spTimeInterval);
        context=this;

        //Activity sendActivity = SendActivity.class;
        submit_button = findViewById(R.id.btn_submit);
        cancel_button = findViewById(R.id.btn_cancel);

        Intent intent = getIntent();
        isReceiver = intent.getIntExtra("isReceiver", -1);

        if (isReceiver == 0){
            // 從send頁面取得的經緯度資訊存起來準備
            Bundle bundle = getIntent().getExtras();
            originAddress = bundle.getString("origin_address");
            destAddress = bundle.getString("dest_address");
            receiver_id = bundle.getString("receiver_id");
            sender_id = bundle.getString("sender_id");
            price = bundle.getInt("price");
            weight = bundle.getDouble("weight");
            cargo_content = bundle.getString("cargo_content");
            size = bundle.getInt("size");
            // Toast.makeText(this,sender_id,Toast.LENGTH_LONG).show();
            // 從前一個ACTIVITY取得地址後把地址轉為經緯度
            LatLng originLL = getLocationFromAddress(originAddress);
            lng1 = originLL.longitude;
            lat1 = originLL.latitude;
            LatLng destLL = getLocationFromAddress(destAddress);
            lng2 = destLL.longitude;
            lat2 = destLL.latitude;

            hashmap.put("sender_id", sender_id);
            hashmap.put("receiver_id",receiver_id);
            hashmap.put("price",price);
            hashmap.put("weight",weight);
            hashmap.put("cargo_content", cargo_content);
            hashmap.put("size", size);
            hashmap.put("request_No", 0);
            hashmap.put("sender_lng", lng1);
            hashmap.put("sender_lat", lat1);
            hashmap.put("receiver_lng", lng2);
            hashmap.put("receiver_lat", lat2);
            hashmap.put("container_id","000");

            camaraLng2 = lng1;
            cameraLat2 = lat1;

            for (int i=0; i<12; i++){
                timeSelect[i] =i+1;
            }

            ArrayAdapter<CharSequence> timeListSender = ArrayAdapter.createFromResource(this, R.array.timeInterval, android.R.layout.simple_spinner_dropdown_item);
            spinnerTime.setAdapter(timeListSender);
        }
        else if (isReceiver == 1 ){
            order_item = (Item)intent.getExtras().getSerializable("order_item");
            String timeArrived = intent.getExtras().getString("timeFilter");

            Toast.makeText(this,timeArrived,Toast.LENGTH_LONG).show();
            double[] lnglat = order_item.getLnglat();
            receiver_id = order_item.getReceiverName();
            sender_id = order_item.getSenderName();
            price = order_item.getPrice();
            cargo_content = order_item.getCargoContent();
            weight = 0.0;
            size = 0;
            // 陣列依序為 sender_lng, sender_lat, receiver_lng, receiver_lat
            lng1 = lnglat[0];
            lat1 = lnglat[1];
            lng2 = lnglat[2];
            lat2 = lnglat[3];

            container_id = order_item.getContainerNo();
            String truck_id = order_item.getTruckNo();
            String order_No = order_item.getOrderNo();

            hashmap.put("sender_id", sender_id);
            hashmap.put("receiver_id",receiver_id);
            hashmap.put("price",price);
            hashmap.put("weight",weight);
            hashmap.put("cargo_content", cargo_content);
            hashmap.put("size", size);
            hashmap.put("request_No", 1);
            hashmap.put("sender_lng", lng1);
            hashmap.put("sender_lat", lat1);
            hashmap.put("receiver_lng", lng2);
            hashmap.put("receiver_lat", lat2);
            hashmap.put("container_id", container_id);
            hashmap.put("truck_id", truck_id);
            hashmap.put("order_No", order_No);

            camaraLng2 = lng2;
            cameraLat2 = lat2;

            // 我們先創造一個陣列，並再陣列放入幾個資料
            /*
            timeFilterList = new ArrayList<String>();
            int select = 0;
            for (int ss=0; ss<12; ss++){
                if (timeArrived.charAt(ss)=='1'){
                   timeSelect[select] = ss+1;
                   select++;
                   switch(ss){
                       case 0:
                           timeFilterList.add("09:30");
                           break;
                       case 1:
                           timeFilterList.add("10:00");
                           break;
                       case 2:
                           timeFilterList.add("10:30");
                           break;
                       case 3:
                           timeFilterList.add("11:00");
                           break;
                       case 4:
                           timeFilterList.add("11:30");
                           break;
                       case 5:
                           timeFilterList.add("12:00");
                           break;
                       case 6:
                           timeFilterList.add("12:30");
                           break;
                       case 7:
                           timeFilterList.add("13:00");
                           break;
                       case 8:
                           timeFilterList.add("13:30");
                           break;
                       case 9:
                           timeFilterList.add("14:00");
                           break;
                       case 10:
                           timeFilterList.add("14:30");
                           break;
                       case 11:
                           timeFilterList.add("15:00");
                           break;
                   }
                }
            }
            */
            //我們先創造一個陣列，並再陣列放入幾個資料
            // timeFilterList.add("111");

            //我們再創造一個配接線 (Context，選單布局呈現方式，List<>)
            //adapterForTimeFilter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, timeFilterList);
            ArrayAdapter<CharSequence> timeListSender = ArrayAdapter.createFromResource(this, R.array.timeInterval, android.R.layout.simple_spinner_dropdown_item);
            spinnerTime.setAdapter(timeListSender);
        }

        cameraLng = (lng1+lng2)/2;
        cameraLat = (lat1+lat2)/2;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // 下拉式選單
        // ArrayAdapter<CharSequence> adapterForTimeFilter = ArrayAdapter.createFromResource(this, R.array.timeInterval, android.R.layout.simple_spinner_dropdown_item);
        // spinnerTime.setAdapter(adapterForTimeFilter);

        // 使用者點選下拉式選單中的選項
        spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 判斷使用者目前選擇的到達時間
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timeArrived = timeSelect[position];
                hashmap.put("time_arrived", timeArrived);
                // 測試選擇時間
                Toast.makeText(MapTestActivity.this, hashmap.get("time_arrived").toString(), Toast.LENGTH_SHORT).show();
            }
            // 因預設會選擇L，因此不可能觸發此函式，但此介面必須覆寫
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // 使用者點選確定，啟用 socket ，與 sumo 進行溝通，並指定上貨、卸貨時間
        View.OnClickListener submitListener = new View.OnClickListener() {
            @SuppressLint("HandlerLeak")
            @Override
            public void onClick(View view) {
                //finish();
                dialog = ProgressDialog.show(MapTestActivity.this,
                        "讀取中", "正在確認派遣車輛...",true);
                handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        // SUMO 回傳 1 代表派遣成功
                        // SUMO 回傳 0 代表此時段無車可以到達
                        // SUMO 回傳 -1 代表使用者選擇的貨櫃尺寸皆已滿載
                        // SUMO 回傳 -2 代表系統忙碌中 (車輛處於路口)
                        if(msg.what == 1) {
                            dialog.dismiss();
                            Toast.makeText(MapTestActivity.this,"貨車已派遣成功，請從「我的訂單」查看車輛狀態。", Toast.LENGTH_LONG).show();
                            if (isReceiver == 0){
                                SendActivity.instance.finish();
                            }
                            else if (isReceiver == 1){
                                ItemActivity.instance.finish();
                                MyOrderActivity.instance.finish();
                            }
                            finish();
                        }
                        else if (msg.what == 0){
                            dialog.dismiss();
                            Toast.makeText(MapTestActivity.this,"本時段無車可以到達。", Toast.LENGTH_SHORT).show();
                        }
                        else if (msg.what == -1){
                            dialog.dismiss();
                            Toast.makeText(MapTestActivity.this,"此貨櫃大小已經滿載，請選擇其他尺寸或稍後下單。", Toast.LENGTH_SHORT).show();
                        }
                        else if (msg.what == -2){
                            dialog.dismiss();
                            Toast.makeText(MapTestActivity.this,"系統忙碌中，請重新輸入一次。", Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                jsonW = new JSONObject(hashmap);
                Thread threadSocket = new Thread(Connection);
                threadSocket.start();
                /*jsonW = new JSONObject(hashmap);
                Thread threadSocket = new Thread(Connection);
                threadSocket.start();
                System.out.println("123");*/
            }
        };
        submit_button.setOnClickListener(submitListener);

        // 使用者點選取消 ，目前拿來測試 socket 用
        View.OnClickListener cancelListener = new View.OnClickListener() {
            @SuppressLint("HandlerLeak")
            @Override
            public void onClick(View view) {
                finish();
                /*dialog = ProgressDialog.show(MapTestActivity.this,
                        "讀取中", "正在確認派遣車輛...",true);
                handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        // SUMO 回傳 1 代表派遣成功
                        // SUMO 回傳 0 代表此時段無車可以到達
                        // SUMO 回傳 -1 代表使用者選擇的貨櫃尺寸皆已滿載
                        // SUMO 回傳 -2 代表系統忙碌中 (車輛處於路口)
                        if(msg.what == 1) {
                            dialog.dismiss();
                            Toast.makeText(MapTestActivity.this,"貨車已派遣成功，請從「我的訂單」查看車輛狀態。", Toast.LENGTH_LONG).show();
                            // SendActivity.instance.finish();
                            // finish();
                        }
                        else if (msg.what == 0){
                            dialog.dismiss();
                            Toast.makeText(MapTestActivity.this,"本時段無車可以到達。", Toast.LENGTH_LONG).show();
                        }
                        else if (msg.what == -1){
                            dialog.dismiss();
                            Toast.makeText(MapTestActivity.this,"此貨櫃大小已經滿載，請選擇其他尺寸或稍後下單。", Toast.LENGTH_LONG).show();
                        }
                        else if (msg.what == -2){
                            dialog.dismiss();
                            Toast.makeText(MapTestActivity.this,"系統忙碌中，請再輸入一次。", Toast.LENGTH_LONG).show();
                        }
                    }
                };
                jsonW = new JSONObject(hashmap);
                Thread threadSocket = new Thread(Connection);
                threadSocket.start();
                */
            }
        };
        cancel_button.setOnClickListener(cancelListener);
    }
    // 與 sumo 進行溝通，並指定上貨、卸貨時間
    private Runnable Connection = new Runnable() {
        @Override
        public void run() {
            OutputStream output = null;
            InputStream input = null;
            try{
                // 0610 記得改回來
                // InetAddress serverIP = InetAddress.getByName("140.116.72.162");
                String ip_add = getString(R.string.ip_address);
                InetAddress serverIP = InetAddress.getByName(ip_add);
                int serverPort = 6678;
                clientSocket = new Socket(serverIP, serverPort);
                // 取得網路輸出流 //////////////////////////////////////////
                output = new DataOutputStream(clientSocket.getOutputStream());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
                // 將訂單資訊傳送至 sumo server
                bw.write(jsonW.toString());
                bw.flush();
                // 只關閉輸出流
                clientSocket.shutdownOutput();
                // 取得網路輸入流 /////////////////////////////////////////////
                input = new DataInputStream(clientSocket.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                while (clientSocket.isConnected()) {
                    //宣告一個緩衝,從br串流讀取 Server 端傳來的訊息
                    temp = br.readLine();
                    if (temp != null) {
                        break;
                    }
                }
                System.out.println(temp);
                bw.close();
                br.close();
                output.close();
                input.close();
                // 通知 UI 關閉讀取畫面
                //Message msg = new Message();
                Message msg = new Message();
                // SUMO 回傳 1 代表派遣成功
                // SUMO 回傳 0 代表此時段無車可以到達
                // SUMO 回傳 -1 代表使用者選擇的貨櫃尺寸皆已滿載
                // SUMO 回傳 -2 代表系統忙碌中 (車輛處於路口)
                if (temp != null){
                    System.out.println("Sumo return: "+ temp);
                    msg.what = Integer.parseInt(temp);
                }
                else{
                    msg.what = 99;
                }
                handler.sendMessage(msg);
            }
            catch (Exception e){
                //當斷線時會跳到 catch,可以在這裡處理斷開連線後的邏輯
                e.printStackTrace();
                System.out.println("斷線囉~~");
                Log.e("text","Socket連線="+e.toString());
            }
            finally
            {
                try
                {
                    if ( input != null )
                        input.close();
                    if ( output != null )
                        output.close();
                    if ( clientSocket != null && !clientSocket.isClosed() )
                        clientSocket.close();
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        }
    };
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng origin = new LatLng(lat1, lng1);
        LatLng dest = new LatLng(lat2,lng2);
        LatLng cameraPlace = new LatLng(cameraLat, cameraLng);
        LatLng cameraPlace2 = new LatLng(cameraLat2, camaraLng2);
        if (isReceiver == 0){
            mMap.addMarker(new MarkerOptions().position(origin).title("貨車收貨地點"));
            // mMap.addMarker(new MarkerOptions().position(dest).title("送貨目的地點"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cameraPlace2, 13.0f));
        }
        else if (isReceiver == 1){
            // mMap.addMarker(new MarkerOptions().position(origin).title("寄件人上貨地點"));
            mMap.addMarker(new MarkerOptions().position(dest).title("您的取貨地點"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cameraPlace2, 13.0f));
        }
    }
    /// 地址轉經緯度!!
    public LatLng getLocationFromAddress(String Address) {
        Geocoder coder = new Geocoder(this);
        List<Address> address;
        LatLng point = null;
        try {
            address = coder.getFromLocationName(Address, 5);
            if (address == null)
                return null;
            Address location = address.get(0);
            point = new LatLng(location.getLatitude(),location.getLongitude());
        } catch (IOException e) {
            e.getMessage();
        }
        return point;
    }
}