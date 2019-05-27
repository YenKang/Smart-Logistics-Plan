package com.example.bjt.av_delivery_v10;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderQueryByNo extends AsyncTask<String, Integer, String> {
    Context ctx;
    OrderQueryByNo(Context ctx){
        this.ctx = ctx;
    }

    // 意味不明的東西
    @Override
    protected void onPreExecute() {
    }
    // 再背景中處理的耗時工作，為主要查詢的部分
    @Override
    protected String doInBackground(String... params) {
        // 連上 web server 中確定收件人存在的查詢功能 (ReceiverQuery.php)
        String queryReceiverUrl = "http://140.116.72.134/AV_user/OrderQueryByNo.php";
        // 將傳入的收件人帳號存入變數，以便進行後續查詢
        String order_No = params[0];
        try{
            // 建立連線，以GET方式取得 web server 之資料
            URL url = new URL(queryReceiverUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);

            // 將資料輸出到伺服器
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data = URLEncoder.encode("order_number","UTF-8")+"="+URLEncoder.encode(order_No,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            // 從伺服器輸入資料
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            // 將資料逐行讀入字串 response
            String response ="";
            String line ="";
            while ((line = bufferedReader.readLine()) != null){
                response = response + line;
            }
            bufferedReader.close();
            inputStream.close();
            // 最後關閉 web server 的連線並回傳結果
            httpURLConnection.disconnect();
            return response;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "網路中斷"+e;
        }
    }
    // 背景程序處理完後回傳的結果
    public void onPostExecute(String result )
    {
        super.onPreExecute();
        //Toast.makeText(, result, Toast.LENGTH_LONG).show();
        //System.out.println(result);
        // 若伺服器回傳 "No_match" 則表示查詢失敗，表示使用者輸入錯誤
        if (result.equals("No_match")) {
            Toast.makeText(ctx, "查無此訂單！", Toast.LENGTH_SHORT).show();
        }
        else  {
            // Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
            try {
                // 以jsonArray形式儲存從資料庫取得的訂單資料
                JSONArray orderArray = new JSONArray(result);

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

                        Item item = new Item(i, order_No, sender_name, receiver_name, cargo_content, price,
                                container_No, in_time, out_time, status, truck_No, lnglat, order_time, sender_time, receiver_time);


                        Intent intent = new Intent(ctx, ItemActivity.class);
                        // 設定記事編號與標題
                        intent.putExtra("item", item);
                        // 呼叫「startActivityForResult」，第二個參數「1」表示執行修改
                        ctx.startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    // 意味不明的東西
    @Override
    protected void onProgressUpdate(Integer... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
        // 背景工作處理"中"更新的事
    }
}
