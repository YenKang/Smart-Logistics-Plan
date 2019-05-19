package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
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
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MapTestActivity extends FragmentActivity implements OnMapReadyCallback {

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
    private Button submit_button;
    // private TextView tvLng1, tvLat1, tvLng2, tvLat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_test);
        submit_button = findViewById(R.id.btn_submit);
       /* tvLng1 = findViewById(R.id.lng1);
        tvLat1 = findViewById(R.id.lat1);
        tvLng2 = findViewById(R.id.lng2);
        tvLat2 = findViewById(R.id.lat2);*/

        // 從send頁面取得的經緯度資訊存起來準備
        Bundle bundle = getIntent().getExtras();
        originAddress = bundle.getString("origin_address");
        destAddress = bundle.getString("dest_address");
        receiver_id = bundle.getString("receiver_id");
        sender_id = bundle.getString("cargo_content");
        price = bundle.getInt("price");
        weight = bundle.getDouble("weight");
        cargo_content = bundle.getString("cargo_content");
        size = bundle.getInt("size");

        Toast.makeText(this,sender_id,Toast.LENGTH_LONG).show();

        /// 從前一個ACTIVITY取得地址後把地址轉為經緯度
        LatLng originLL = getLocationFromAddress(originAddress);
        lng1 = originLL.longitude;
        lat1 = originLL.latitude;

        LatLng destLL = getLocationFromAddress(destAddress);
        lng2 = destLL.longitude;
        lat2 = destLL.latitude;

        cameraLng = (lng1+lng2)/2;
        cameraLat = (lat1+lat2)/2;

        Spinner spinnerSize = findViewById(R.id.spTimeInterval);
        final ArrayAdapter<CharSequence> timeList = ArrayAdapter.createFromResource(this, R.array.timeInterval, android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setAdapter(timeList);
        spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 判斷使用者目前選擇的到達時間
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timeArrived = position;
                //Toast.makeText(MapTestActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                // 測試是否顯示正確選擇
                // Toast.makeText(SendActivity.this, Integer.toString(sizeSelected), Toast.LENGTH_SHORT).show();
            }
            // 因預設會選擇L，因此不可能觸發此函式，但此介面必須覆寫
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Map hashmap = new HashMap();
        hashmap.put("sender_id", sender_id);
        hashmap.put("receiver_id",receiver_id);
        hashmap.put("price",price);
        hashmap.put("weight",weight);
        hashmap.put("cargo_content", cargo_content);
        hashmap.put("size", size);
        hashmap.put("request_No", 0);
        // 22.996193, 120.220860
        hashmap.put("sender_lng", lng1);
        hashmap.put("sender_lat", lat1);
        hashmap.put("receiver_lng", lng2);
        hashmap.put("receiver_lat", lat2);
        hashmap.put("time_arrived", timeArrived);
        jsonW = new JSONObject(hashmap);

        // Toast.makeText(this, lng1.toString(), Toast.LENGTH_LONG).show();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // 使用者點選確定
        View.OnClickListener submitListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread threadSocket = new Thread(Connection);
                threadSocket.start();
                System.out.println("123");
            }
        };
        submit_button.setOnClickListener(submitListener);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng origin = new LatLng(lat1, lng1);
        LatLng dest = new LatLng(lat2,lng2);
        LatLng cameraPlace = new LatLng(cameraLat, cameraLng);
        mMap.addMarker(new MarkerOptions().position(origin).title("貨車取貨地點"));
        mMap.addMarker(new MarkerOptions().position(dest).title("送貨目的地點"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cameraPlace, 8.0f));
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
    // 測試連線
    private Runnable Connection = new Runnable() {
        @Override
        public void run() {
            OutputStream output = null;
            InputStream input = null;
            try{
                InetAddress serverIP = InetAddress.getByName("140.116.72.134");
                int serverPort = 6678;
                clientSocket = new Socket(serverIP, serverPort);

                // 取得網路輸出流 //////////////////////////////////////////
                output = new DataOutputStream(clientSocket.getOutputStream());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
                //bw.write("123");
                bw.write(jsonW.toString());
                bw.flush();
                // 指關閉輸出流
                clientSocket.shutdownOutput();

                // 取得網路輸入流 /////////////////////////////////////////////
                input = new DataInputStream(clientSocket.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                temp = br.readLine();
                System.out.println(temp);
                bw.close();
                br.close();
                output.close();
                input.close();
                //clientSocket.close();
                /*while (clientSocket.isConnected()) {
                    //宣告一個緩衝,從br串流讀取 Server 端傳來的訊息
                    temp = br.readLine();
                    System.out.println(temp);
                    //break;
                }*/
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
