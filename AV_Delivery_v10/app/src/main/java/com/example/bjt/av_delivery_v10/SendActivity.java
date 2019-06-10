package com.example.bjt.av_delivery_v10;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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

public class SendActivity extends AppCompatActivity {

    private Button mapTest, bt_next;
    // 宣告讓使用者選擇地址的按鈕
    private TextView origin, dest;
    // 宣告貨物大小
    private int sizeSelected;
    // 宣告訂單的各個內容，如貨品名稱及細部地址等
    private EditText cargo_name, price, weight, receiver_id, et_origin, et_dest;
    private String sender_id;
    // 將來使用者選擇地址後，將整合地址放入的字串
    private String originAddressSelected="";
    private String destAddressSelected="";

    static SendActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        instance =this;
        // 使用 sharedpreferences 判斷使用者是否已在此裝置登入過，若 user_id 不存在則預設 -1
        SharedPreferences sharedPreferences = getSharedPreferences("user_info",0);
        int login = sharedPreferences.getInt("user_id",-1);
        // 若使用者未曾登入過，則自動跳至登入頁面 (login)
        if (login == -1){
            Intent it = new Intent(this, Login.class);
            this.startActivity(it);
            finish();
        }
        // 若有使用者登入資訊，則正式執行本頁面，將對應欄位的layout指派好
        else{
            sender_id = sharedPreferences.getString("username","");
            origin = findViewById(R.id.bt_origin);
            dest = findViewById(R.id.bt_dest);
            bt_next = findViewById(R.id.btn_next);
            mapTest = findViewById(R.id.btn_mapTest);
            cargo_name = findViewById(R.id.etCargoName);
            price = findViewById(R.id.etPrice);
            weight = findViewById(R.id.etWeight);
            receiver_id = findViewById(R.id.etReceiverID);
            et_origin = findViewById(R.id.etOrigin);
            et_dest = findViewById(R.id.etDest);
            // 負責監聽按鈕事件的函式
            processControllers();
            // 使用下拉式選單定義貨物 size
            Spinner spinnerSize = findViewById(R.id.spSize);
            final ArrayAdapter<CharSequence> sizeList = ArrayAdapter.createFromResource(this, R.array.size, android.R.layout.simple_spinner_dropdown_item);
            spinnerSize.setAdapter(sizeList);
            spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                // 判斷使用者目前選擇的貨櫃大小，預設為L，0為L、1為M、2為S
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    sizeSelected = position + 1;
                    // 測試是否顯示正確選擇
                     Toast.makeText(SendActivity.this, Integer.toString(sizeSelected), Toast.LENGTH_SHORT).show();
                }
                // 因預設會選擇L，因此不可能觸發此函式，但此介面必須覆寫
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
    }
    // 負責監聽本頁面所有按鈕事件的函式
    private void processControllers() {
        // 測試用按鍵，跳入 MapTest 頁面，進行後續地圖及連線測試
        View.OnClickListener accountListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MapTestActivity.class);
                // 標示為 sender
                i.putExtra("isReceiver", 0);
                // 使用 bundle 將頁面資訊傳送給下一階段，準備與 SUMO SERVER 連線
                Bundle bundle = new Bundle();
                /*
                bundle.putString("origin_address",originAddressSelected + et_origin.getText().toString());
                bundle.putString("dest_address",destAddressSelected + et_dest.getText().toString());
                bundle.putString("sender_id",sender_id);
                bundle.putString("cargo_content",cargo_name.getText().toString());
                bundle.putInt("price",Integer.parseInt(price.getText().toString()));
                bundle.putDouble("weight",Double.parseDouble(weight.getText().toString()));
                bundle.putString("receiver_id", receiver_id.getText().toString());
                bundle.putInt("size",sizeSelected);
                */
                /*
                bundle.putString("origin_address","台南市中西區忠義路二段63號");
                bundle.putString("dest_address", "台南市東區大學路17號");
                bundle.putString("sender_id","Bryan1023");
                bundle.putString("cargo_content","測試用貨物");
                bundle.putInt("price",777);
                bundle.putDouble("weight",40.0);
                bundle.putString("receiver_id", "Bryan1023");
                bundle.putInt("size",sizeSelected);
                i.putExtras(bundle);
                startActivity(i);
                */

                originAddressSelected = "台南市中西區";
                destAddressSelected = "台南市東區";
                origin.setText(originAddressSelected);
                dest.setText(destAddressSelected);
                receiver_id.setText("Bryan1023");
                cargo_name.setText("測試用貨物");
                price.setText("777");
                weight.setText("30.0");
                et_origin.setText("忠義路二段63號");
                et_dest.setText("大學路17號");
            }
        };
        mapTest.setOnClickListener(accountListener);
        // 使用者選擇收貨地址的事件
        View.OnClickListener originListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AddressActivity.class);
                startActivityForResult(i,0);
            }
        };
        origin.setOnClickListener(originListener);
        // 使用者選擇目的地址的事件
        View.OnClickListener destListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AddressActivity.class);
                startActivityForResult(i,1);
            }
        };
        dest.setOnClickListener(destListener);
        // 以上兩個事件會根據不同的 requestCode 將回傳的結果傳入不同的變數 //////
        // 使用者選擇下一步，此為正式版本的功能，真實流程的一部份
        View.OnClickListener nextListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 檢查使用者是否輸入完整資料
                if (price.getText().toString().equals("")||cargo_name.getText().toString().equals("")||
                        weight.getText().toString().equals("")||receiver_id.getText().toString().equals("")||
                        et_origin.getText().toString().equals("")||et_dest.getText().toString().equals(""))
                {
                    // new ReceiverQuery().execute(receiver_id.getText().toString());
                    Toast.makeText(view.getContext(),"請完整填寫資料!!",Toast.LENGTH_LONG).show();
                }
                // 若無空白則檢查收件人是否存在
                else {
                    new ReceiverQuery().execute(receiver_id.getText().toString());
                    // Toast.makeText(view.getContext(),"123!!",Toast.LENGTH_LONG).show();
                }
                // Intent i = new Intent(view.getContext(), AddressActivity.class);
                // startActivityForResult(i,1);
                // origin.setText("123");
            }
        };
        bt_next.setOnClickListener(nextListener);
    }

    // 根據前面使用者選擇的地址及 requestCode 將寄件人及收件人地址傳入目標變數
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode ==Activity.RESULT_OK){
            if (requestCode == 0){
                originAddressSelected = data.getExtras().getString("addressSelected");
                origin.setText(originAddressSelected);
            }
            else if (requestCode ==1){
                destAddressSelected = data.getExtras().getString("addressSelected");
                dest.setText(destAddressSelected);
            }
        }
    }

    // 檢查使用者輸入的收件人帳號是否存在
    class ReceiverQuery extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
        }
        // 再背景中處理的耗時工作
        @Override
        protected String doInBackground(String... params) {
            // 連上 web server 中確定收件人存在的查詢功能 (ReceiverQuery.php)
            // 0610 記得要改
            String queryReceiverUrl = "http://140.116.72.162/AV_user/ReceiverQuery.php";
            // 將傳入的收件人帳號存入變數，以便進行後續查詢
            String receiver_id = params[0];
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
                String data = URLEncoder.encode("receiver_id","UTF-8")+"="+URLEncoder.encode(receiver_id,"UTF-8");
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
            // 若伺服器回傳 "No_match" 則表示查詢失敗，表示使用者輸入錯誤
            if (result.equals("No_match")) {
                Toast.makeText(SendActivity.this, "收件人帳號不存在！", Toast.LENGTH_LONG).show();
            }
            else  {
                Intent i = new Intent(SendActivity.this, MapTestActivity.class);
                i.putExtra("isReceiver", 0);
                // 使用 bundle 將頁面資訊傳送給下一階段，準備與 SUMO SERVER 連線
                Bundle bundle = new Bundle();
                bundle.putString("origin_address",originAddressSelected + et_origin.getText().toString());
                bundle.putString("dest_address",destAddressSelected + et_dest.getText().toString());
                bundle.putString("sender_id",sender_id);
                bundle.putString("cargo_content",cargo_name.getText().toString());
                bundle.putInt("price",Integer.parseInt(price.getText().toString()));
                bundle.putDouble("weight",Double.parseDouble(weight.getText().toString()));
                bundle.putString("receiver_id", receiver_id.getText().toString());
                bundle.putInt("size",sizeSelected);
                i.putExtras(bundle);
                startActivity(i);
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
}
