package com.example.bjt.av_delivery_v10;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ItemActivity extends AppCompatActivity  {

    //private TextView cargo_content_text, price_text;

    //private GoogleMap mMap;
    private Item order_item;
    private TextView order_No_text, cargo_content_text, price_text, status_text, truck_No_text,
        container_No_text, sender_name_text, receiver_name_text;
    private Button receive_time_btn, return_btn;

    private TextView arrived_time_name, arrived_time;
    private String status;

    static ItemActivity instance;


    private Dialog dialog;
    private Handler handler;
    private Socket clientSocket;
    private JSONObject jsonR, jsonW;
    private Map hashmap = new HashMap();
    private String temp, timeFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        instance = this;
        order_No_text = findViewById(R.id.order_No_activity_text);
        cargo_content_text = findViewById(R.id.cargo_content_activity_text);
        price_text = findViewById(R.id.price_activity_text);
        status_text = findViewById(R.id.status_activity_text);
        truck_No_text = findViewById(R.id.truck_No_activity_text);
        container_No_text = findViewById(R.id.container_activity_text);
        sender_name_text = findViewById(R.id.sender_name_activity_text);
        receiver_name_text = findViewById(R.id.receiver_name_activity_text);
        receive_time_btn = findViewById(R.id.btn_receive_time);
        return_btn = findViewById(R.id.btn_return);

        arrived_time_name = findViewById(R.id.arrived_time_name);
        arrived_time = findViewById(R.id.arrived_time);

        Intent intent = getIntent();
        order_item = (Item)intent.getExtras().getSerializable("item");
        int isReceiver = intent.getExtras().getInt("receiver");
        // 若為收件人
        if (isReceiver == 1){
            receive_time_btn.setVisibility(View.VISIBLE);
            arrived_time_name.setText("貨物到達時間");
            if (order_item.getReceiverTime()==0){
                arrived_time.setText("尚未選擇取貨時間");
            }else{
                switch (order_item.getSenderTime()){
                    case 1:
                        arrived_time.setText("09:30");
                        break;
                    case 2:
                        arrived_time.setText("10:00");
                        break;
                    case 3:
                        arrived_time.setText("10:30");
                        break;
                    case 4:
                        arrived_time.setText("11:00");
                        break;
                    case 5:
                        arrived_time.setText("11:30");
                        break;
                    case 6:
                        arrived_time.setText("12:00");
                        break;
                    case 7:
                        arrived_time.setText("12:30");
                        break;
                    case 8:
                        arrived_time.setText("13:00");
                        break;
                    case 9:
                        arrived_time.setText("13:30");
                        break;
                    case 10:
                        arrived_time.setText("14:00");
                        break;
                    case 11:
                        arrived_time.setText("14:30");
                        break;
                    case 12:
                        arrived_time.setText("15:00");
                        break;
                }
            }
            // arrived_time.setText(order_item.getReceiverTime());
        }
        // 若為寄件人
        else if (isReceiver == 0){
            arrived_time_name.setText("貨車收貨時間");
            switch (order_item.getSenderTime()){
                case 1:
                    arrived_time.setText("09:30");
                    break;
                case 2:
                    arrived_time.setText("10:00");
                    break;
                case 3:
                    arrived_time.setText("10:30");
                    break;
                case 4:
                    arrived_time.setText("11:00");
                    break;
                case 5:
                    arrived_time.setText("11:30");
                    break;
                case 6:
                    arrived_time.setText("12:00");
                    break;
                case 7:
                    arrived_time.setText("12:30");
                    break;
                case 8:
                    arrived_time.setText("13:00");
                    break;
                case 9:
                    arrived_time.setText("13:30");
                    break;
                case 10:
                    arrived_time.setText("14:00");
                    break;
                case 11:
                    arrived_time.setText("14:30");
                    break;
                case 12:
                    arrived_time.setText("15:00");
                    break;
            }
            // arrived_time.setText(order_item.getSenderTime());
        }

        String order_No = order_item.getOrderNo();
        String cargo_content = order_item.getCargoContent();
        int price = order_item.getPrice();
        status = order_item.getStatus();
        String truck_No = order_item.getTruckNo();
        String container_No = order_item.getContainerNo();
        String sender_name = order_item.getSenderName();
        String receiver_name = order_item.getReceiverName();
        order_No_text.setText(order_No);
        cargo_content_text.setText(cargo_content);
        price_text.setText(Integer.toString(price));
        switch (status.charAt(0)){
            case '0':
                status_text.setText("貨車正在前往寄件人地點");
                break;
            case '1':
                status_text.setText("貨車已到達寄件人地點");
                break;
            case '2':
                status_text.setText("貨物已上車，等待收件人\n選擇取貨時間");
                break;
            case '3':
                status_text.setText("貨車正在前往收件人地點");
                break;
            case '4':
                status_text.setText("貨車已到達收件人地點，\n等待收件");
                break;
            case '5':
                status_text.setText("收件人已簽收完成");
                break;
        }
        truck_No_text.setText(truck_No);
        container_No_text.setText(container_No);
        sender_name_text.setText(sender_name);
        receiver_name_text.setText(receiver_name);

        // 收件人選擇收件時間
        View.OnClickListener receiver_timeListener = new View.OnClickListener() {
            @SuppressLint("HandlerLeak")
            @Override
            public void onClick(View view) {
                switch (status.charAt(0)){
                    case '0':
                        Toast.makeText(ItemActivity.this,"貨物尚未到達寄件者位置。",Toast.LENGTH_SHORT).show();
                        break;
                    case '1':
                        Toast.makeText(ItemActivity.this,"正在等待寄件者上貨。",Toast.LENGTH_SHORT).show();
                        break;
                    case '2':
                        /*Intent i = new Intent(view.getContext(), MapTestActivity.class);
                        i.putExtra("isReceiver", 1);
                        i.putExtra("order_item", order_item);
                        startActivity(i);*/

                        double[] lnglat = order_item.getLnglat();
                        double receiver_lng = lnglat[2];
                        double receiver_lat = lnglat[3];

                        hashmap.put("request_No", 2);
                        hashmap.put("receiver_lng", receiver_lng);
                        hashmap.put("receiver_lat", receiver_lat);
                        hashmap.put("sender_lng", 0.0);
                        hashmap.put("sender_lat", 0.0);
                        hashmap.put("container_id", order_item.getContainerNo());
                        hashmap.put("truck_id", order_item.getTruckNo());
                        //finish();
                        dialog = ProgressDialog.show(ItemActivity.this,
                                "讀取中", "正在搜尋可用車輛...",true);
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
                                    Toast.makeText(ItemActivity.this,"已過濾出可選時間。", Toast.LENGTH_LONG).show();
                                    Intent i = new Intent(ItemActivity.this, MapTestActivity.class);
                                    i.putExtra("isReceiver", 1);
                                    i.putExtra("order_item", order_item);
                                    i.putExtra("timeFilter", timeFilter);
                                    startActivity(i);
                                    finish();
                                }
                                else if (msg.what == 0){
                                    dialog.dismiss();
                                    Toast.makeText(ItemActivity.this,"目前沒有可到達車輛。", Toast.LENGTH_SHORT).show();
                                    // Toast.makeText(ItemActivity.this, timeFilter, Toast.LENGTH_SHORT).show();
                                }
                                else if (msg.what == -2){
                                    dialog.dismiss();
                                    Toast.makeText(ItemActivity.this,"系統忙碌中。", Toast.LENGTH_SHORT).show();
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
                        break;
                    case '3':
                        Toast.makeText(ItemActivity.this,"已選擇過取貨時間。",Toast.LENGTH_SHORT).show();
                        break;
                    case '4':
                        Toast.makeText(ItemActivity.this,"已選擇過取貨時間。",Toast.LENGTH_SHORT).show();
                        break;
                    case '5':
                        Toast.makeText(ItemActivity.this,"已選擇過取貨時間。",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        receive_time_btn.setOnClickListener(receiver_timeListener);

        // 返回訂單列表
        View.OnClickListener returnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        return_btn.setOnClickListener(returnListener);
    }

    // 與 sumo 進行溝通，以篩選可選之貨車到達時間
    private Runnable Connection = new Runnable() {
        @Override
        public void run() {
            OutputStream output = null;
            InputStream input = null;
            try{
                // 0610 記得改回來
                // InetAddress serverIP = InetAddress.getByName("140.116.72.162");
                InetAddress serverIP = InetAddress.getByName("140.116.72.134");
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
                    timeFilter = br.readLine();
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
}
