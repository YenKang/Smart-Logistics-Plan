package com.example.bjt.av_delivery_v10;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapTestActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String originAddress, destAddress;
    private Double lng1, lat1, lng2, lat2, cameraLng, cameraLat;
    private Button submit_button;
    private TextView tvLng1, tvLat1, tvLng2, tvLat2;

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
        // Toast.makeText(this,originAddress,Toast.LENGTH_LONG).show();

        /*Geocoder gc = new Geocoder(this ,Locale.TRADITIONAL_CHINESE);
        List<Address> lstAddress = null;
        try {
            lstAddress = gc.getFromLocation(22.9958755, 120.2230923, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String returnAddress=lstAddress.get(0).getAddressLine(0);
        Toast.makeText(this, returnAddress, Toast.LENGTH_LONG).show();*/

        /// 從前一個ACTIVITY取得地址後把地址轉為經緯度
        LatLng originLL = getLocationFromAddress(originAddress);
        lng1 = originLL.longitude;
        lat1 = originLL.latitude;
        LatLng destLL = getLocationFromAddress(destAddress);
        lng2 = destLL.longitude;
        lat2 = destLL.latitude;
        cameraLng = (lng1+lng2)/2;
        cameraLat = (lat1+lat2)/2;
        /*tvLng1.setText(lng1.toString());
        tvLat1.setText(lat1.toString());
        tvLng2.setText(lng2.toString());
        tvLat2.setText(lat2.toString());*/

        // Toast.makeText(this, lng1.toString(), Toast.LENGTH_LONG).show();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


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
}
