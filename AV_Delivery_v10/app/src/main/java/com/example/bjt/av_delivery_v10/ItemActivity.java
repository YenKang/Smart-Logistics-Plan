package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ItemActivity extends AppCompatActivity  {

    //private TextView cargo_content_text, price_text;

    private GoogleMap mMap;
    private Item order_item;
    private TextView order_No_text, cargo_content_text, price_text, status_text, truck_No_text,
        container_No_text, sender_name_text, receiver_name_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        order_No_text = findViewById(R.id.order_No_activity_text);
        cargo_content_text = findViewById(R.id.cargo_content_activity_text);
        price_text = findViewById(R.id.price_activity_text);
        status_text = findViewById(R.id.status_activity_text);
        truck_No_text = findViewById(R.id.truck_No_activity_text);
        container_No_text = findViewById(R.id.container_activity_text);
        sender_name_text = findViewById(R.id.sender_name_activity_text);
        receiver_name_text = findViewById(R.id.receiver_name_activity_text);

        Intent intent = getIntent();
        order_item = (Item)intent.getExtras().getSerializable("item");
        String order_No = order_item.getOrderNo();
        String cargo_content = order_item.getCargoContent();
        int price = order_item.getPrice();
        int status = order_item.getStatus();
        String truck_No = order_item.getTruckNo();
        String container_No = order_item.getContainerNo();
        String sender_name = order_item.getSenderName();
        String receiver_name = order_item.getReceiverName();
        order_No_text.setText(order_No);
        cargo_content_text.setText(cargo_content);
        price_text.setText(Integer.toString(price));
        switch (status){
            case -1:
                status_text.setText("貨車尚未出發");
                break;
            case 0:
                status_text.setText("貨車正在前往收貨地點");
                break;
            case 1:
                status_text.setText("貨車已到達寄件人地點，準備收貨");
                break;
            case 2:
                status_text.setText("貨車已收件，正在前往送貨地點");
                break;
            case 3:
                status_text.setText("貨車已到達收件人地點，等待取貨");
                break;
        }
        truck_No_text.setText(truck_No);
        container_No_text.setText(container_No);
        sender_name_text.setText(sender_name);
        receiver_name_text.setText(receiver_name);


        //Toast.makeText(this,order_item.getOrderNo(),Toast.LENGTH_SHORT).show();

    }
}
