package com.example.bjt.av_delivery_v10;

import java.sql.Time;
import java.sql.Timestamp;

public class Item implements java.io.Serializable {

    private int item_id;
    private String order_No;
    private String sender_name;
    private String receiver_name;
    private String cargo_content;
    private int price;
    private String container_No;
    private Timestamp in_time, out_time;
    private String status;
    private String truck_No;
    private double[] lnglat;
    private Timestamp order_time;
    private int sender_time, receiver_time;

    public Item(int item_id,String order_No, String sender_name, String receiver_name, String cargo_content,
                int price, String container_No, Timestamp in_time, Timestamp out_time, String status,
                String truck_No, double[] lnglat, Timestamp order_time, int sender_time, int receiver_time){
        this.item_id = item_id;
        this.order_No = order_No;
        this.sender_name = sender_name;
        this.receiver_name = receiver_name;
        this.cargo_content = cargo_content;
        this.price = price;
        this.container_No = container_No;
        this.in_time = in_time;
        this.out_time = out_time;
        this.status = status;
        this.truck_No = truck_No;
        this.lnglat = lnglat;
        this.order_time = order_time;
        this.sender_time = sender_time;
        this.receiver_time = receiver_time;
    }
    public int getItemId(){
        return item_id;
    }

    public Timestamp getOrderTime(){
        return order_time;
    }

    public String getOrderNo(){
        return order_No;
    }

    public String getSenderName(){
        return sender_name;
    }

    public String getReceiverName(){
        return receiver_name;
    }

    public String getCargoContent(){
        return cargo_content;
    }

    public int getPrice(){
        return price;
    }

    public String getContainerNo(){
        return container_No;
    }

    public Timestamp getInTime(){
        return in_time;
    }

    public Timestamp getOutTime(){
        return out_time;
    }

    public String getStatus(){
        return status;
    }

    public String getTruckNo(){
        return truck_No;
    }

    public double[] getLnglat(){
        return lnglat;
    }

    public int getSenderTime(){
        return sender_time;
    }

    public int getReceiverTime(){
        return receiver_time;
    }
}
