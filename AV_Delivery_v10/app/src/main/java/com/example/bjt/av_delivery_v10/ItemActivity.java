package com.example.bjt.av_delivery_v10;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ItemActivity extends AppCompatActivity  {

    //private TextView cargo_content_text, price_text;

    //private GoogleMap mMap;
    private Item order_item;
    private TextView order_No_text, cargo_content_text, price_text, status_text, truck_No_text,
        container_No_text, sender_name_text, receiver_name_text;
    private Button receive_time_btn, return_btn;

    private TextView arrived_time_name, arrived_time;
    private String status;

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
                status_text.setText("貨車正在前往收件人地點");
                break;
            case '3':
                status_text.setText("貨車已到達收件人地點");
                break;
        }
        truck_No_text.setText(truck_No);
        container_No_text.setText(container_No);
        sender_name_text.setText(sender_name);
        receiver_name_text.setText(receiver_name);

        // 收件人選擇收件時間
        View.OnClickListener receiver_timeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status.charAt(0) == '0'){
                    Toast.makeText(ItemActivity.this,"貨物尚未到達寄件者位置。",Toast.LENGTH_SHORT).show();
                }
                else if ((status.charAt(0) == '1') && (status.charAt(1) == '0')) {
                    Intent i = new Intent(view.getContext(), MapTestActivity.class);
                    i.putExtra("isReceiver", 1);
                    i.putExtra("order_item", order_item);
                    startActivity(i);
                }
                else if ((status.charAt(0) == '1') && (status.charAt(1) == '1')){
                    Toast.makeText(ItemActivity.this, "您已選擇取貨時間！", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ItemActivity.this, "您已選擇取貨時間！", Toast.LENGTH_SHORT).show();
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
}
