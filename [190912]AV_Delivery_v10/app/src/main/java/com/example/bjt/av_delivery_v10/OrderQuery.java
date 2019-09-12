package com.example.bjt.av_delivery_v10;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;

// 根據使用者名稱取得該使用者的 Order 資料
class OrderQuery extends AsyncTask<String, Integer, String> {

    Context ctx;
    OrderQuery(Context ctx){
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
        // 0610 記得改回來
        // String queryReceiverUrl = "http://140.116.72.162/AV_user/OrderQuery.php";
        String ip_add = ctx.getString(R.string.ip_address);
        String queryReceiverUrl = "http://"+ ip_add +"/AV_user/OrderQuery.php";
        // 將傳入的收件人帳號存入變數，以便進行後續查詢
        String user_name = params[0];
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
            String data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8");
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
        // 若伺服器回傳 "No_match" 則表示查詢失敗，表示使用者輸入錯誤
        if (result.equals("No_match")) {
            Toast.makeText(ctx, "您目前沒有訂單！", Toast.LENGTH_SHORT).show();
        }
        else  {
            //Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
            try {
                // 以jsonArray形式儲存從資料庫取得的訂單資料
                JSONArray jsonArray = new JSONArray(result);
                // 以自定義的類別物件將取得的 JSON 格式資料以 Serialize 的格式存入 Bundle
                SerializableJSONArray jsonReceiver = new SerializableJSONArray(jsonArray);
                Intent it = new Intent(ctx, MyOrderActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("orderReceived", jsonReceiver);
                // 跳轉至 MyOrderActivity 後即可使用 bundle 中的資料
                it.putExtras(bundle);
                ctx.startActivity(it);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                //Intent intent = new Intent(ctx, MapTestActivity.class);
                //startActivity(intent,2);
                //Toast.makeText(SendActivity.this, result, Toast.LENGTH_LONG).show();
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
