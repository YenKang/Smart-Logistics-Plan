package com.example.bjt.av_delivery_v10;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AddressActivity extends AppCompatActivity {

    private Button[] buttons;
    private int arraySize;
    private GridLayout gridLayout;
    private String countySelected = "", townshipSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        gridLayout = findViewById(R.id.root);
        new GetCounty().execute();
    }

    class GetCounty extends AsyncTask<String, Integer, String> {
        //
        protected void onPreExecute() {
        }
        //
        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            // 再背景中處理的耗時工作
            String countyUrl = "http://140.116.72.134/AV_user/GetCounty.php";
            try{
                /// 建立連線，以GET方式取得 web serber 之資料
                URL url = new URL(countyUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(15000);

                /// 讀取資料
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                /// 放入回傳值中
                String response ="";
                String line ="";
                while ((line = bufferedReader.readLine()) != null){
                    response = response + line;
                }
                bufferedReader.close();
                inputStream.close();
                ///
                httpURLConnection.disconnect();
                return response;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return "網路中斷"+e;
            }
        }
        //
        public void onPostExecute(String result )
        {
            super.onPreExecute();
            // 背景工作處理完"後"需作的事
            // mytest.setText("JSON:\r\n"+ result);
            //Toast.makeText(AddressActivity.this,result,Toast.LENGTH_LONG).show();
            if (result.equals("No_match")) {
                Toast.makeText(AddressActivity.this, "查無縣市資料。", Toast.LENGTH_LONG).show();
            }
            else {
                try {
                    /// 以jsonArray形式儲存從資料庫取得的縣市資料
                    JSONArray jsonArray = new JSONArray(result);
                    ////// 準備動態顯示按鈕於畫面上
                    /// 設計按鈕的寬度，使用個別裝置的螢幕大小做比例
                    DisplayMetrics metrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(metrics); //抓取螢幕大小的資料
                    int width = (metrics.widthPixels/7)*2 ;
                    /// 從資料庫取得之資料數判斷欲動態產生的按鈕個數
                    arraySize = jsonArray.length();
                    //Toast.makeText(AddressActivity.this,result,Toast.LENGTH_LONG).show();
                    buttons = new Button[arraySize];
                    /// 每一列設定為最多顯示三個按鈕
                    gridLayout.setColumnCount(3);
                    for (int i =0; i <arraySize; i++){
                        final int countyID = jsonArray.getJSONObject(i).getInt("ID");
                        final String county_name = jsonArray.getJSONObject(i).getString("county_name");
                        buttons[i] = new Button(AddressActivity.this);
                        buttons[i].setWidth(width);
                        buttons[i].setText(county_name);
                        buttons[i].setTextSize(18);
                        buttons[i].setId(countyID);
                        gridLayout.addView(buttons[i]);
                        buttons[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Toast.makeText(AddressActivity.this,county_name,Toast.LENGTH_LONG).show();
                                countySelected = county_name;
                                // Toast.makeText(AddressActivity.this,countySelected,Toast.LENGTH_LONG).show();
                                for (int i = 0; i < arraySize; i++)
                                    gridLayout.removeView(buttons[i]);
                                new GetTownShip().execute(Integer.toString(countyID));
                            }
                        });
                    }
                    //Toast.makeText(AddressActivity.this, test1, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(AddressActivity.this, result, Toast.LENGTH_LONG).show();
            }
        }
        //
        @Override
        protected void onProgressUpdate(Integer... values) {
            // TODO Auto-generated method stub
            super.onProgressUpdate(values);
            // 背景工作處理"中"更新的事
        }
    }

    class GetTownShip extends AsyncTask<String, Integer, String> {
        //
        protected void onPreExecute() {
        }
        //
        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            // 再背景中處理的耗時工作
            String countyUrl = "http://140.116.72.134/AV_user/GetTownShip.php";
            int county_id = Integer.parseInt(params[0]);
            try{
                /// 建立連線，以GET方式取得 web server 之資料
                URL url = new URL(countyUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(15000);

                /// 傳入參數給伺服器
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("county_id","UTF-8")+"="+county_id;
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                /// 讀取資料
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                /// 放入回傳值中
                String response ="";
                String line ="";
                while ((line = bufferedReader.readLine()) != null){
                    response = response + line;
                }
                bufferedReader.close();
                inputStream.close();
                ///
                httpURLConnection.disconnect();
                return response;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return "網路中斷"+e;
            }
        }
        //
        public void onPostExecute(String result )
        {
            super.onPreExecute();
            // 背景工作處理完"後"需作的事
            // mytest.setText("JSON:\r\n"+ result);
            if (result.equals("No_match")) {
                Toast.makeText(AddressActivity.this, "查無縣市資料。", Toast.LENGTH_LONG).show();
            }
            else {
                try {
                    /// 以jsonArray形式儲存從資料庫取得的縣市資料
                    JSONArray jsonArray = new JSONArray(result);
                    ////// 準備動態顯示按鈕於畫面上
                    /// 設計按鈕的寬度，使用個別裝置的螢幕大小做比例
                    DisplayMetrics metrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(metrics); //抓取螢幕大小的資料
                    int width = (metrics.widthPixels/7)*2 ;
                    /// 從資料庫取得之資料數判斷欲動態產生的按鈕個數
                    final int arraySize = jsonArray.length();
                    buttons = new Button[arraySize];
                    /// 每一列設定為最多顯示三個按鈕
                    gridLayout.setColumnCount(3);
                    for (int i =0; i <arraySize; i++){
                        final int townshipID = jsonArray.getJSONObject(i).getInt("ID");
                        final String township_name = jsonArray.getJSONObject(i).getString("township_name");
                        buttons[i] = new Button(AddressActivity.this);
                        buttons[i].setWidth(width);
                        buttons[i].setText(township_name);
                        buttons[i].setTextSize(18);
                        buttons[i].setId(townshipID);
                        gridLayout.addView(buttons[i]);
                        buttons[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                townshipSelected = township_name;
                                Intent intentReturn = new Intent();
                                intentReturn.putExtra("addressSelected", countySelected + townshipSelected);
                                setResult(Activity.RESULT_OK, intentReturn);
                                finish();
                                // Toast.makeText(AddressActivity.this,countySelected+townshipSelected,Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    //Toast.makeText(AddressActivity.this, test1, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        //
        @Override
        protected void onProgressUpdate(Integer... values) {
            // TODO Auto-generated method stub
            super.onProgressUpdate(values);
            // 背景工作處理"中"更新的事
        }
    }



}
